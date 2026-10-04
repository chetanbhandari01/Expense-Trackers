package com.chetanbhandari.expensemanager.core.repository

import com.chetanbhandari.expensemanager.core.model.Country

interface CountryRepository {

    suspend fun readCountries(): List<Country>
}
