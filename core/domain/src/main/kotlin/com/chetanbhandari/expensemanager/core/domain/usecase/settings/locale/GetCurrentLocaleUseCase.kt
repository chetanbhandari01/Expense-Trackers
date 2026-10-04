package com.chetanbhandari.expensemanager.core.domain.usecase.settings.locale

import com.chetanbhandari.expensemanager.core.model.AppLocale
import com.chetanbhandari.expensemanager.core.repository.LocaleRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentLocaleUseCase(private val repository: LocaleRepository) {

    operator fun invoke(): Flow<AppLocale> = repository.getSelectedLocale()
}
