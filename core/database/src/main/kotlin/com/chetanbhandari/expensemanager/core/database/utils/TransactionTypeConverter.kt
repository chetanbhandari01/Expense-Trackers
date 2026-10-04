package com.chetanbhandari.expensemanager.core.database.utils

import androidx.room.TypeConverter
import com.chetanbhandari.expensemanager.core.model.TransactionType

object TransactionTypeConverter {

    @TypeConverter
    fun ordinalToTransactionType(value: Int?): TransactionType? = value?.let { TransactionType.entries[it] }

    @TypeConverter
    fun transactionTypeToOrdinal(transactionType: TransactionType?): Int? = transactionType?.ordinal
}
