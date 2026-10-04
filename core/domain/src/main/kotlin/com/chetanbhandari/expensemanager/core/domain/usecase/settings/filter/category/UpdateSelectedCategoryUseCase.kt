package com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.category

import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.SettingsRepository

class UpdateSelectedCategoryUseCase(
    private val settingsRepository: SettingsRepository,
) {

    suspend operator fun invoke(categories: List<String>?): Resource<Boolean> = settingsRepository.setCategories(categories)
}
