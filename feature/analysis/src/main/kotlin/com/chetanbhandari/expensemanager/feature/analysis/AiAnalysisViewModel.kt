package com.chetanbhandari.expensemanager.feature.analysis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chetanbhandari.expensemanager.core.common.utils.AppCoroutineDispatchers
import com.chetanbhandari.expensemanager.core.domain.usecase.budget.GetBudgetsUseCase
import com.chetanbhandari.expensemanager.core.domain.usecase.settings.currency.GetCurrencyUseCase
import com.chetanbhandari.expensemanager.core.domain.usecase.transaction.GetTransactionWithFilterUseCase
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.model.Transaction
import com.chetanbhandari.expensemanager.core.repository.OllamaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import com.chetanbhandari.expensemanager.core.model.TransactionType
import com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.daterange.GetDateRangeUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn


sealed class AiAnalysisState {
    object Idle : AiAnalysisState()
    object Loading : AiAnalysisState()
    data class Success(val explanation: String) : AiAnalysisState()
    data class Error(val message: String) : AiAnalysisState()
}

class AiAnalysisViewModel(
    private val getTransactionWithFilterUseCase: GetTransactionWithFilterUseCase,
    private val getBudgetsUseCase: GetBudgetsUseCase,
    private val getCurrencyUseCase: GetCurrencyUseCase,
    private val getDateRangeUseCase: GetDateRangeUseCase,
    private val ollamaRepository: OllamaRepository,
    private val dispatchers: AppCoroutineDispatchers
) : ViewModel() {

    private val _uiState = MutableStateFlow<AiAnalysisState>(AiAnalysisState.Idle)
    val uiState: StateFlow<AiAnalysisState> = _uiState.asStateFlow()

    private var currentPeriodString: String = ""

    init {
        getDateRangeUseCase.invoke()
            .onEach { dateRange ->
                val newPeriod = if (dateRange.description.isNotEmpty()) {
                    "${dateRange.name} (${dateRange.description})"
                } else {
                    dateRange.name
                }

                if (currentPeriodString.isNotEmpty() && currentPeriodString != newPeriod) {
                    _uiState.value = AiAnalysisState.Idle
                }
                currentPeriodString = newPeriod
            }
            .launchIn(viewModelScope)
    }

    fun analyzeSpending() {
        if (_uiState.value is AiAnalysisState.Loading) return

        _uiState.value = AiAnalysisState.Loading

        viewModelScope.launch(dispatchers.io) {
            try {
                // 1. Gather data
                val transactions = getTransactionWithFilterUseCase.invoke().firstOrNull() ?: emptyList()
                val currency = getCurrencyUseCase.invoke().firstOrNull()?.symbol ?: ""
                val budgets = getBudgetsUseCase.invoke().firstOrNull() ?: emptyList()

                // 2. Generate summary
                val summary = generateSummary(transactions, budgets, currency, currentPeriodString)

                // Add debug logging
                println("AI Spending Insights: Requesting analysis for period: $currentPeriodString")
                println("AI Spending Insights: Total transactions: ${transactions.size}")

                // 3. Request explanation from Ollama
                when (val result = ollamaRepository.getSpendingExplanation(summary)) {
                    is Resource.Success -> {
                        _uiState.value = AiAnalysisState.Success(result.data)
                    }
                    is Resource.Error -> {
                        _uiState.value = AiAnalysisState.Error(result.exception.message ?: "Unknown error")
                    }
                }
            } catch (e: Exception) {
                _uiState.value = AiAnalysisState.Error(e.message ?: "Unknown error")
            }
        }
    }

    private fun generateSummary(
        transactions: List<Transaction>,
        budgets: List<com.chetanbhandari.expensemanager.core.domain.usecase.budget.BudgetUiModel>,
        currency: String,
        periodString: String
    ): String {
        val income = transactions.filter { it.type == TransactionType.INCOME }.sumOf { it.amount.amount }
        val expenses = transactions.filter { it.type == TransactionType.EXPENSE }.sumOf { it.amount.amount }
        val savings = income - expenses

        val categoryTotals = transactions
            .filter { it.type == TransactionType.EXPENSE }
            .groupBy { it.category.name }
            .mapValues { entry -> entry.value.sumOf { it.amount.amount } }
            .entries.sortedByDescending { it.value }

        val budgetInfo = budgets.joinToString("\n") {
            "${it.name}: $currency${it.amount.amount} (Spent: $currency${it.transactionAmount.amount})"
        }

        val categoriesStr = categoryTotals.take(5).joinToString("\n") {
            "${it.key}: $currency${it.value}"
        }

        println("AI Spending Insights: Total Income: $currency$income")
        println("AI Spending Insights: Total Expenses: $currency$expenses")
        println("AI Spending Insights: Top Categories: \n$categoriesStr")

        return """
            Please analyze the spending for the period: $periodString

            Income: $currency$income
            Expenses: $currency$expenses
            Savings: $currency$savings

            Top Expense Categories:
            $categoriesStr

            Budgets:
            ${if (budgetInfo.isNotBlank()) budgetInfo else "No budgets set."}
        """.trimIndent()
    }
}
