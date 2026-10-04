package com.chetanbhandari.expensemanager.core.domain.usecase.category

import com.chetanbhandari.expensemanager.core.model.Category
import com.chetanbhandari.expensemanager.core.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class FindCategoryByIdFlowUseCase(private val repository: CategoryRepository) {

    operator fun invoke(categoryId: String): Flow<Category?> = repository.findCategoryFlow(categoryId)
}
