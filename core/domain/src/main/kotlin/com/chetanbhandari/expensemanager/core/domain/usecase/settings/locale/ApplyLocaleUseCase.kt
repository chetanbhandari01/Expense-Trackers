package com.chetanbhandari.expensemanager.core.domain.usecase.settings.locale

import com.chetanbhandari.expensemanager.core.repository.LocaleRepository

class ApplyLocaleUseCase(private val repository: LocaleRepository) {

    suspend operator fun invoke() {
        repository.applyLocale()
    }
}
