package com.chetanbhandari.expensemanager.core.repository

interface JsonConverterRepository {

    suspend fun fromJsonToObject(value: String, classValue: Class<*>): Any?

    suspend fun fromObjectToJson(value: Any): String?
}
