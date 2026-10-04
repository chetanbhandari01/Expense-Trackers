package com.chetanbhandari.expensemanager.core.repository

import com.chetanbhandari.expensemanager.core.model.ExportData
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.model.Transaction

interface ExportRepository {

    suspend fun createCsvFile(uri: String?, transactions: List<Transaction>): Resource<ExportData>

    suspend fun createPdfFile(uri: String?, transactions: List<Transaction>): Resource<ExportData>
}
