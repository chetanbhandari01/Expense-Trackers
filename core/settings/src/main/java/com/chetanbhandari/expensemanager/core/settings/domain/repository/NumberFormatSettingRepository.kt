package com.chetanbhandari.expensemanager.core.settings.domain.repository

import com.chetanbhandari.expensemanager.core.settings.domain.model.NumberFormatType
import kotlinx.coroutines.flow.Flow

interface NumberFormatSettingRepository {

    fun getNumberFormatType(): Flow<NumberFormatType>

    suspend fun saveNumberFormatType(numberFormatType: NumberFormatType)
}
