package com.chetanbhandari.expensemanager.feature.country

import com.chetanbhandari.expensemanager.core.model.Country

sealed class CountrySelectionEvent {

    data class CountrySelected(val country: Country) : CountrySelectionEvent()

    data object Dismiss : CountrySelectionEvent()
}
