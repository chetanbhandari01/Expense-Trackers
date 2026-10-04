package com.chetanbhandari.expensemanager.core.domain.usecase.settings.theme

import com.chetanbhandari.expensemanager.core.model.Theme
import com.chetanbhandari.expensemanager.core.repository.ThemeRepository

class GetThemesUseCase(private val repository: ThemeRepository) {

    operator fun invoke(): List<Theme> = repository.getThemes()
}
