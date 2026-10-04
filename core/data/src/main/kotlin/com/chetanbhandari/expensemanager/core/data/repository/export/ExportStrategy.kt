package com.chetanbhandari.expensemanager.core.data.repository.export

import com.chetanbhandari.expensemanager.core.model.ExportData
import com.chetanbhandari.expensemanager.core.model.ExportFileType
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.model.Transaction

interface ExportStrategy {

    fun getFileType(): ExportFileType

    fun export(uri: String?, transactions: List<Transaction>): Resource<ExportData>
}
