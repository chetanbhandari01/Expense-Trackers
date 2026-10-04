package com.chetanbhandari.expensemanager.feature.category.transaction

import com.chetanbhandari.expensemanager.core.model.CategoryTransaction

sealed class CategoryTransactionAction {

    data object SwitchCategoryType : CategoryTransactionAction()

    data object OpenTransactionCreate : CategoryTransactionAction()

    data class OpenCategoryDetails(val transaction: CategoryTransaction) : CategoryTransactionAction()

    data object OpenCategoryList : CategoryTransactionAction()
}
