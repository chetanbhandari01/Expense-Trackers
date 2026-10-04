package com.chetanbhandari.expensemanager.feature.filter

import com.chetanbhandari.expensemanager.core.model.AccountUiModel
import com.chetanbhandari.expensemanager.core.model.Category
import com.chetanbhandari.expensemanager.core.model.TransactionType

sealed class FilterAction {

    data object MoveDateForward : FilterAction()

    data object MoveDateBackward : FilterAction()

    data object ShowDateFilter : FilterAction()

    data object DismissDateFilter : FilterAction()

    data object ShowTypeFilter : FilterAction()

    data object DismissTypeFilter : FilterAction()

    data class RemoveAccount(val account: AccountUiModel) : FilterAction()

    data class RemoveCategory(val category: Category) : FilterAction()

    data class RemoveTransactionType(val transactionType: TransactionType) : FilterAction()
}
