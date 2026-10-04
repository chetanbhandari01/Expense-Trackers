package com.chetanbhandari.expensemanager.core.domain.usecase.settings.export

import com.chetanbhandari.expensemanager.core.domain.usecase.transaction.GetExportTransactionsUseCase
import com.chetanbhandari.expensemanager.core.model.AccountUiModel
import com.chetanbhandari.expensemanager.core.model.DateRangeType
import com.chetanbhandari.expensemanager.core.model.ExportData
import com.chetanbhandari.expensemanager.core.model.ExportFileType
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.ExportRepository

class ExportFileUseCase(
    private val exportRepository: ExportRepository,
    private val getExportTransactionsUseCase: GetExportTransactionsUseCase,
) {

    suspend operator fun invoke(
        exportFileType: ExportFileType,
        uri: String?,
        dateRangeType: DateRangeType,
        accounts: List<AccountUiModel>,
        isAllAccountsSelected: Boolean,
    ): Resource<ExportData> = when (
        val transactions = getExportTransactionsUseCase.invoke(
            dateRangeType,
            accounts.map { it.id },
            isAllAccountsSelected,
        )
    ) {
        is Resource.Error -> {
            transactions
        }

        is Resource.Success -> {
            when (exportFileType) {
                ExportFileType.CSV -> {
                    exportRepository.createCsvFile(uri, transactions.data)
                }

                ExportFileType.PDF -> {
                    exportRepository.createPdfFile(uri, transactions.data)
                }
            }
        }
    }
}
