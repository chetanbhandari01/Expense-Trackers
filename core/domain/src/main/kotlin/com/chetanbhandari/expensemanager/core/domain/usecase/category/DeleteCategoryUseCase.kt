package com.chetanbhandari.expensemanager.core.domain.usecase.category

import com.chetanbhandari.expensemanager.core.model.Category
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.CategoryRepository

class DeleteCategoryUseCase(
    private val repository: CategoryRepository,
    private val checkCategoryValidationUseCase: CheckCategoryValidationUseCase,
) {

    suspend operator fun invoke(category: Category): Resource<Boolean> = when (val validationResult = checkCategoryValidationUseCase(category)) {
        is Resource.Error -> {
            validationResult
        }

        is Resource.Success -> {
            repository.deleteCategory(category)
        }
    }
}
