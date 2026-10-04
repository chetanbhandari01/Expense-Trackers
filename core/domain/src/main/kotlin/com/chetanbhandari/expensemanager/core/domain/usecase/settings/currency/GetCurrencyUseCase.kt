package com.chetanbhandari.expensemanager.core.domain.usecase.settings.currency

import com.chetanbhandari.expensemanager.core.model.Currency
import com.chetanbhandari.expensemanager.core.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow

class GetCurrencyUseCase(private val repository: CurrencyRepository) {
    operator fun invoke(): Flow<Currency> = repository.getSelectedCurrency()
}
