package com.chetanbhandari.expensemanager.feature.transaction.list

sealed class TransactionListAction {

    data object ClosePage : TransactionListAction()

    data object OpenCreateTransaction : TransactionListAction()

    data class OpenEdiTransaction(val transactionId: String) : TransactionListAction()
}
