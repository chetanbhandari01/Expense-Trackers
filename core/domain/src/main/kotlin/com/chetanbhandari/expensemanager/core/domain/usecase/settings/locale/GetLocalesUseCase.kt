package com.chetanbhandari.expensemanager.core.domain.usecase.settings.locale

import com.chetanbhandari.expensemanager.core.model.AppLocale
import com.chetanbhandari.expensemanager.core.repository.LocaleRepository

class GetLocalesUseCase(private val repository: LocaleRepository) {

    operator fun invoke(): List<AppLocale> = repository.getLocales()
}
