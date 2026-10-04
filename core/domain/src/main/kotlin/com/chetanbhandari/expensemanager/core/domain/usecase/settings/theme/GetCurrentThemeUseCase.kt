package com.chetanbhandari.expensemanager.core.domain.usecase.settings.theme

import com.chetanbhandari.expensemanager.core.model.Theme
import com.chetanbhandari.expensemanager.core.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentThemeUseCase(private val repository: ThemeRepository) {

    operator fun invoke(): Flow<Theme> = repository.getSelectedTheme()
}
