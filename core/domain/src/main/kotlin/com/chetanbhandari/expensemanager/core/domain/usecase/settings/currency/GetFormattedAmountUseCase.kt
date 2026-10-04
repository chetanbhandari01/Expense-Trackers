package com.chetanbhandari.expensemanager.core.domain.usecase.settings.currency

import com.chetanbhandari.expensemanager.core.model.Amount
import com.chetanbhandari.expensemanager.core.model.Currency
import com.chetanbhandari.expensemanager.core.repository.CurrencyRepository

class GetFormattedAmountUseCase(private val repository: CurrencyRepository) {
    operator fun invoke(amount: Double, currency: Currency): Amount = repository.getFormattedCurrency(
        Amount(amount = amount, currency = currency),
    )
}
