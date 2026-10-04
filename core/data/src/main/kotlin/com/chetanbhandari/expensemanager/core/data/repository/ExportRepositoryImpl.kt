package com.chetanbhandari.expensemanager.core.data.repository

import com.chetanbhandari.expensemanager.core.common.utils.AppCoroutineDispatchers
import com.chetanbhandari.expensemanager.core.data.repository.export.ExportStrategy
import com.chetanbhandari.expensemanager.core.model.ExportData
import com.chetanbhandari.expensemanager.core.model.ExportFileType
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.model.Transaction
import com.chetanbhandari.expensemanager.core.repository.ExportRepository
import kotlinx.coroutines.withContext

class ExportRepositoryImpl(
    private val dispatchers: AppCoroutineDispatchers,
    private val strategies: List<ExportStrategy>,
) : ExportRepository {

    override suspend fun createCsvFile(
        uri: String?,
        transactions: List<Transaction>,
    ): Resource<ExportData> = withContext(dispatchers.io) {
        strategy(ExportFileType.CSV).export(uri, transactions)
    }

    override suspend fun createPdfFile(
        uri: String?,
        transactions: List<Transaction>,
    ): Resource<ExportData> = withContext(dispatchers.io) {
        strategy(ExportFileType.PDF).export(uri, transactions)
    }

    private fun strategy(type: ExportFileType): ExportStrategy = strategies.first { it.getFileType() == type }
}
