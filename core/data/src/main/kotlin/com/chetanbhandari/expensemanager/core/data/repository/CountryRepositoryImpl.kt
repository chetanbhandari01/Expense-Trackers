package com.chetanbhandari.expensemanager.core.data.repository

import android.content.Context
import com.chetanbhandari.expensemanager.core.common.utils.AppCoroutineDispatchers
import com.chetanbhandari.expensemanager.core.data.dto.CountriesResponseDto
import com.chetanbhandari.expensemanager.core.data.mappers.toDomainModel
import com.chetanbhandari.expensemanager.core.data.utils.convertFileToString
import com.chetanbhandari.expensemanager.core.model.Country
import com.chetanbhandari.expensemanager.core.repository.CountryRepository
import com.chetanbhandari.expensemanager.core.repository.JsonConverterRepository
import kotlinx.coroutines.withContext

/**
 * Repository Implementation. Which carries the information about how we are reading the countries
 * information from the json files.
 */
class CountryRepositoryImpl(
    private val context: Context,
    private val jsonConverterRepository: JsonConverterRepository,
    private val dispatchers: AppCoroutineDispatchers,
) : CountryRepository {

    override suspend fun readCountries(): List<Country> = withContext(dispatchers.io) {
        return@withContext context.convertFileToString(fileName = "countries.json")
            ?.let { jsonString ->
                return@let (
                    jsonConverterRepository.fromJsonToObject(
                        jsonString,
                        CountriesResponseDto::class.java,
                    ) as? CountriesResponseDto
                    )?.counties?.mapNotNull {
                    it.toDomainModel()
                }
            } ?: emptyList()
    }
}
