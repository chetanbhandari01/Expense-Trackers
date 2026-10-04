package com.chetanbhandari.expensemanager.feature.export

import com.chetanbhandari.expensemanager.core.designsystem.ui.utils.UiText
import com.chetanbhandari.expensemanager.core.model.ExportData

sealed class ExportEvent {

    data class Error(val message: UiText) : ExportEvent()

    data object CreateFile : ExportEvent()

    data class FileExported(
        val message: UiText,
        val exportData: ExportData,
    ) : ExportEvent()
}
