package com.chetanbhandari.expensemanager.feature.transaction.list

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chetanbhandari.expensemanager.core.common.utils.AppCoroutineDispatchers
import com.chetanbhandari.expensemanager.core.common.utils.getAmountTextColor
import com.chetanbhandari.expensemanager.core.common.utils.toCompleteDateWithDate
import com.chetanbhandari.expensemanager.core.domain.usecase.settings.currency.GetCurrencyUseCase
import com.chetanbhandari.expensemanager.core.domain.usecase.settings.currency.GetFormattedAmountUseCase
import com.chetanbhandari.expensemanager.core.domain.usecase.transaction.GetTransactionWithFilterUseCase
import com.chetanbhandari.expensemanager.core.model.Transaction
import com.chetanbhandari.expensemanager.core.model.TransactionGroup
import com.chetanbhandari.expensemanager.core.model.TransactionType
import com.chetanbhandari.expensemanager.core.model.TransactionUiItem
import com.chetanbhandari.expensemanager.core.model.toTransactionUIModel
import com.chetanbhandari.expensemanager.core.navigation.AppComposeNavigator
import com.chetanbhandari.expensemanager.core.navigation.ExpenseManagerScreens
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update

class TransactionListViewModel(
    getCurrencyUseCase: GetCurrencyUseCase,
    getFormattedAmountUseCase: GetFormattedAmountUseCase,
    getTransactionWithFilterUseCase: GetTransactionWithFilterUseCase,
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val appComposeNavigator: AppComposeNavigator,
) : ViewModel() {

    private val _transactions = MutableStateFlow(TransactionListState(emptyList()))
    val state = _transactions.asStateFlow()

    init {
        combine(
            getCurrencyUseCase.invoke(),
            getTransactionWithFilterUseCase.invoke(),
        ) { currency, transactions ->

            val groupedItem = transactions?.groupBy {
                it.createdOn.toCompleteDateWithDate()
            }?.map {
                val totalAmount = it.value.toTransactionSum()
                TransactionGroup(
                    date = it.key,
                    amountTextColor = totalAmount.getAmountTextColor(),
                    totalAmount = getFormattedAmountUseCase.invoke(totalAmount, currency),
                    transactions = it.value.map { transaction ->
                        transaction.toTransactionUIModel(
                            getFormattedAmountUseCase.invoke(
                                transaction.amount.amount,
                                currency,
                            ),
                        )
                    },
                )
            }

            _transactions.update {
                it.copy(
                    transactionListItem = groupedItem?.convertGroupToTransactionListItems()
                        ?: emptyList(),
                )
            }
        }.flowOn(appCoroutineDispatchers.computation).launchIn(viewModelScope)
    }

    private fun openCreateScreen(transactionId: String? = null) {
        appComposeNavigator.navigate(
            ExpenseManagerScreens.TransactionCreate(transactionId),
        )
    }

    private fun closePage() {
        appComposeNavigator.popBackStack()
    }

    fun processAction(action: TransactionListAction) {
        when (action) {
            TransactionListAction.ClosePage -> closePage()
            TransactionListAction.OpenCreateTransaction -> openCreateScreen()
            is TransactionListAction.OpenEdiTransaction -> openCreateScreen(action.transactionId)
        }
    }
}

fun List<Transaction>.toTransactionSum() = this.sumOf {
    when (it.type) {
        TransactionType.INCOME -> {
            it.amount.amount
        }

        TransactionType.EXPENSE -> {
            it.amount.amount * -1
        }

        TransactionType.TRANSFER -> {
            0.0
        }
    }
}

fun List<TransactionGroup>.convertGroupToTransactionListItems(): List<TransactionListItem> = buildList {
    this@convertGroupToTransactionListItems.forEach {
        add(
            TransactionListItem.HeaderItem(
                date = it.date,
                amountTextColor = it.amountTextColor,
                totalAmount = it.totalAmount.amountString ?: "",
            ),
        )

        it.transactions.forEach {
            add(TransactionListItem.TransactionItem(date = it))
        }

        add(TransactionListItem.Divider)
    }
}

sealed class TransactionListItem {

    data class HeaderItem(
        val date: String,
        val amountTextColor: Int,
        val totalAmount: String,
    ) : TransactionListItem()

    data class TransactionItem(
        val date: TransactionUiItem,
    ) : TransactionListItem()

    data object Divider : TransactionListItem()
}
