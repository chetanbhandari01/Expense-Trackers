package com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.transactiontype

import com.chetanbhandari.expensemanager.core.model.TransactionType
import com.chetanbhandari.expensemanager.core.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetSelectedTransactionTypesUseCase(
    private val settingsRepository: SettingsRepository,
) {

    operator fun invoke(): Flow<List<TransactionType>> = settingsRepository.getTransactionTypes().map {
        it ?: emptyList()
    }
}
