package com.chetanbhandari.expensemanager.feature.category.list

import com.chetanbhandari.expensemanager.core.model.Category

sealed class CategoryListAction {

    data object ClosePage : CategoryListAction()

    data object Create : CategoryListAction()

    data class Edit(val item: Category) : CategoryListAction()

    data class ChangeCategory(val type: CategoryTabItems) : CategoryListAction()
}
