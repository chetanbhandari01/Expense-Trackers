package com.chetanbhandari.expensemanager.core.domain.usecase.settings.theme

import com.chetanbhandari.expensemanager.core.repository.ThemeRepository

class ApplyThemeUseCase(private val repository: ThemeRepository) {

    suspend operator fun invoke() {
        repository.applyTheme()
    }
}
