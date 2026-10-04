package com.chetanbhandari.expensemanager.feature.category.details

import androidx.compose.runtime.Stable
import com.chetanbhandari.expensemanager.core.model.CategoryTransaction
import com.chetanbhandari.expensemanager.core.model.TransactionUiItem

@Stable
data class CategoryDetailsState(
    val categoryTransaction: CategoryTransaction?,
    val transactions: List<TransactionUiItem>,
)
