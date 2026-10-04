package com.chetanbhandari.expensemanager.core.domain.usecase.budget

import com.chetanbhandari.expensemanager.core.model.Budget
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.BudgetRepository

class AddBudgetUseCase(
    private val repository: BudgetRepository,
    private val checkBudgetValidateUseCase: CheckBudgetValidateUseCase,
) {

    suspend operator fun invoke(budget: Budget): Resource<Boolean> = when (val validationResult = checkBudgetValidateUseCase(budget)) {
        is Resource.Error -> {
            validationResult
        }

        is Resource.Success -> {
            repository.addBudget(budget)
        }
    }
}
