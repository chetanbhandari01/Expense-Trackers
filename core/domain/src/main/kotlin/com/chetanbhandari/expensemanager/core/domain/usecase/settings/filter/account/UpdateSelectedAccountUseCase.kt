package com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.account

import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.SettingsRepository

class UpdateSelectedAccountUseCase(
    private val settingsRepository: SettingsRepository,
) {

    suspend operator fun invoke(accountId: List<String>?): Resource<Boolean> = settingsRepository.setAccounts(accountId)
}
