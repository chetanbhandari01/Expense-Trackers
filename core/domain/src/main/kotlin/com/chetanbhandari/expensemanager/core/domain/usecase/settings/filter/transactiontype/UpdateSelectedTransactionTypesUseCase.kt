package com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.transactiontype

import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.model.TransactionType
import com.chetanbhandari.expensemanager.core.repository.SettingsRepository

class UpdateSelectedTransactionTypesUseCase(
    private val settingsRepository: SettingsRepository,
) {

    suspend operator fun invoke(categoryTypes: List<TransactionType>?): Resource<Boolean> = settingsRepository.setTransactionTypes(categoryTypes)
}
