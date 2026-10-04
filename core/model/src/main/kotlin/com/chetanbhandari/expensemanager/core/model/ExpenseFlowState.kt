package com.chetanbhandari.expensemanager.core.model

import androidx.compose.runtime.Stable

@Stable
data class ExpenseFlowState(
    val income: String = "",
    val expense: String = "",
    val balance: String = "",
)
