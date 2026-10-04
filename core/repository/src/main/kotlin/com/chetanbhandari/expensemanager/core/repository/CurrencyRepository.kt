package com.chetanbhandari.expensemanager.core.repository

import com.chetanbhandari.expensemanager.core.model.Amount
import com.chetanbhandari.expensemanager.core.model.Currency
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    suspend fun saveCurrency(currency: Currency): Boolean

    fun getDefaultCurrency(): Currency

    fun getSelectedCurrency(): Flow<Currency>

    fun getFormattedCurrency(amount: Amount): Amount
}
