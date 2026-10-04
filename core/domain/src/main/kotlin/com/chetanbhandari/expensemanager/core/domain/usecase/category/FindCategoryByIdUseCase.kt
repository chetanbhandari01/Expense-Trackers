package com.chetanbhandari.expensemanager.core.domain.usecase.category

import com.chetanbhandari.expensemanager.core.model.Category
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.CategoryRepository

class FindCategoryByIdUseCase(private val repository: CategoryRepository) {

    suspend operator fun invoke(categoryId: String?): Resource<Category> {
        if (categoryId.isNullOrBlank()) {
            return Resource.Error(Exception("Provide valid category id value"))
        }

        return repository.findCategory(categoryId)
    }
}
