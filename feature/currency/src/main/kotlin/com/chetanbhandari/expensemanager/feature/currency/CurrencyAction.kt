package com.chetanbhandari.expensemanager.feature.currency

import com.chetanbhandari.expensemanager.core.model.Country
import com.chetanbhandari.expensemanager.core.model.CurrencyPosition
import com.chetanbhandari.expensemanager.core.settings.domain.model.NumberFormatType

sealed class CurrencyAction {

    data object ClosePage : CurrencyAction()

    data object OpenCurrencySelection : CurrencyAction()

    data object DismissCurrencySelection : CurrencyAction()

    data class ChangeCurrencyNumberFormat(val numberFormatType: NumberFormatType) : CurrencyAction()

    data class ChangeCurrencyType(val currencyPosition: CurrencyPosition) : CurrencyAction()

    data class SelectCurrency(val country: Country) : CurrencyAction()
}
