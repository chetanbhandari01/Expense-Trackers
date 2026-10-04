package com.chetanbhandari.expensemanager.core.domain.usecase.settings.locale

import com.chetanbhandari.expensemanager.core.model.AppLocale
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.LocaleRepository

class SaveLocaleUseCase(private val repository: LocaleRepository) {

    suspend operator fun invoke(locale: AppLocale): Resource<Boolean> = Resource.Success(repository.saveLocale(locale))
}
