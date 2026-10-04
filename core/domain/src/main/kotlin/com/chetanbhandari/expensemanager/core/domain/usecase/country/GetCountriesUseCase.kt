package com.chetanbhandari.expensemanager.core.domain.usecase.country

import com.chetanbhandari.expensemanager.core.model.Country
import com.chetanbhandari.expensemanager.core.repository.CountryRepository

class GetCountriesUseCase(private val repository: CountryRepository) {
    suspend operator fun invoke(): List<Country> = repository.readCountries()
}
