package com.chetanbhandari.expensemanager.feature.budget.create

import androidx.compose.runtime.Stable
import com.chetanbhandari.expensemanager.core.model.AccountUiModel
import com.chetanbhandari.expensemanager.core.model.BudgetPeriod
import com.chetanbhandari.expensemanager.core.model.Category
import com.chetanbhandari.expensemanager.core.model.Currency
import com.chetanbhandari.expensemanager.core.model.TextFieldValue
import java.util.Date

@Stable
data class BudgetCreateState(
    val isLoading: Boolean,
    val amount: TextFieldValue<String>,
    val month: TextFieldValue<Date>,
    val periodType: BudgetPeriod = BudgetPeriod.MONTHLY,
    val isAllAccountSelected: Boolean,
    val selectedAccounts: List<AccountUiModel>,
    val isAllCategorySelected: Boolean,
    val selectedCategories: List<Category>,
    val currency: Currency,
    val showDeleteButton: Boolean,
    val showDeleteDialog: Boolean,
    val showAccountSelectionDialog: Boolean,
    val showCategorySelectionDialog: Boolean,
    val showMonthSelection: Boolean,
)
