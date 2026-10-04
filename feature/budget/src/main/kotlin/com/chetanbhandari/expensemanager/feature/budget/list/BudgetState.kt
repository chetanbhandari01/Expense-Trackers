package com.chetanbhandari.expensemanager.feature.budget.list

import androidx.compose.runtime.Stable
import com.chetanbhandari.expensemanager.core.domain.usecase.budget.BudgetUiModel

@Stable
data class BudgetState(
    val isLoading: Boolean,
    val budgets: List<BudgetUiModel>,
)
