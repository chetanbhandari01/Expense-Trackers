package com.chetanbhandari.expensemanager.core.data.mappers

import com.chetanbhandari.expensemanager.core.data.dto.CountryResponseDto
import com.chetanbhandari.expensemanager.core.data.dto.CurrencyResponseDto
import com.chetanbhandari.expensemanager.core.model.Country
import com.chetanbhandari.expensemanager.core.model.Currency

fun CountryResponseDto.toDomainModel(): Country? {
    val currency = currencyResponseDto?.toDomainModel()

    currency ?: return null

    return Country(
        name = name ?: "",
        countryCode = countryCode ?: "",
        currencyCode = currencyCode ?: "",
        currency = currency,
    )
}

fun CurrencyResponseDto.toDomainModel(): Currency = Currency(
    name = name ?: "",
    symbol = symbol ?: "",
    code = code ?: "",
)
