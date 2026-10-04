package com.chetanbhandari.expensemanager.feature.currency

import com.chetanbhandari.expensemanager.core.model.Currency
import com.chetanbhandari.expensemanager.core.settings.domain.model.NumberFormatType

data class CurrencyState(
    val showCurrencySelection: Boolean,
    val numberFormatType: NumberFormatType,
    val currency: Currency,
)
