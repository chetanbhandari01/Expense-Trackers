package com.chetanbhandari.expensemanager.feature.filter

import androidx.compose.runtime.Stable
import com.chetanbhandari.expensemanager.core.model.AccountUiModel
import com.chetanbhandari.expensemanager.core.model.Category
import com.chetanbhandari.expensemanager.core.model.DateRangeType
import com.chetanbhandari.expensemanager.core.model.TransactionType

@Stable
data class FilterState(
    val date: String,
    val dateRangeType: DateRangeType,
    val selectedCategories: List<Category>,
    val selectedAccounts: List<AccountUiModel>,
    val selectedTransactionTypes: List<TransactionType>,
    val showForward: Boolean,
    val showBackward: Boolean,
    val showDateFilter: Boolean,
    val showTypeFilter: Boolean,
)
