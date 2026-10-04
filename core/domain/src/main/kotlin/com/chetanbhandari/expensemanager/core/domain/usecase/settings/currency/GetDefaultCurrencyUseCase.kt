package com.chetanbhandari.expensemanager.core.domain.usecase.settings.currency

import com.chetanbhandari.expensemanager.core.model.Currency
import com.chetanbhandari.expensemanager.core.repository.CurrencyRepository

class GetDefaultCurrencyUseCase(private val repository: CurrencyRepository) {
    operator fun invoke(): Currency = repository.getDefaultCurrency()
}
