package com.chetanbhandari.expensemanager.core.domain.usecase.settings.theme

import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.model.Theme

class SaveThemeUseCase(private val repository: com.chetanbhandari.expensemanager.core.repository.ThemeRepository) {

    suspend operator fun invoke(theme: Theme): Resource<Boolean> = Resource.Success(repository.saveTheme(theme))
}
