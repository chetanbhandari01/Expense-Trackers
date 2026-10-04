package com.chetanbhandari.expensemanager.core.domain.usecase.budget

import com.chetanbhandari.expensemanager.core.common.utils.fromMonthAndYearKey
import com.chetanbhandari.expensemanager.core.common.utils.fromYear
import com.chetanbhandari.expensemanager.core.common.utils.getEndOfTheMonth
import com.chetanbhandari.expensemanager.core.common.utils.getEndOfTheYear
import com.chetanbhandari.expensemanager.core.common.utils.getStartOfTheMonth
import com.chetanbhandari.expensemanager.core.common.utils.getStartOfTheYear
import com.chetanbhandari.expensemanager.core.common.utils.toMonthAndYearKey
import com.chetanbhandari.expensemanager.core.common.utils.toYear
import com.chetanbhandari.expensemanager.core.model.Budget
import com.chetanbhandari.expensemanager.core.model.BudgetPeriod
import com.chetanbhandari.expensemanager.core.model.CategoryType
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.model.Transaction
import com.chetanbhandari.expensemanager.core.repository.AccountRepository
import com.chetanbhandari.expensemanager.core.repository.CategoryRepository
import com.chetanbhandari.expensemanager.core.repository.TransactionRepository
import kotlinx.coroutines.flow.firstOrNull

class GetBudgetTransactionsUseCase(
    private val categoryRepository: CategoryRepository,
    private val accountRepository: AccountRepository,
    private val transactionRepository: TransactionRepository,
) {
    suspend operator fun invoke(budget: Budget): Resource<List<Transaction>> {
        val accounts: List<String> = if (budget.isAllAccountsSelected) {
            accountRepository.getAccounts().firstOrNull()?.map { it.id } ?: emptyList()
        } else {
            budget.accounts
        }

        val categories: List<String> = if (budget.isAllCategoriesSelected) {
            categoryRepository.getCategories().firstOrNull()?.map { it.id } ?: emptyList()
        } else {
            budget.categories
        }

        val isYearly = budget.periodType == BudgetPeriod.YEARLY
        val date = if (isYearly) {
            budget.selectedMonth.fromYear()
        } else {
            budget.selectedMonth.fromMonthAndYearKey()
        }

        date ?: return Resource.Error(IllegalArgumentException("Unknown month value"))

        val startDate = if (isYearly) date.getStartOfTheYear() else date.getStartOfTheMonth()
        val endDate = if (isYearly) date.getEndOfTheYear() else date.getEndOfTheMonth()

        val transaction = transactionRepository.getFilteredTransaction(
            accounts = accounts,
            categories = categories,
            transactionType = CategoryType.entries.map { it.ordinal }.toList(),
            startDate = startDate,
            endDate = endDate,
        ).firstOrNull()?.filter {
            if (isYearly) {
                it.createdOn.toYear() == budget.selectedMonth
            } else {
                it.createdOn.toMonthAndYearKey() == budget.selectedMonth
            }
        }

        return Resource.Success(transaction ?: emptyList())
    }
}
