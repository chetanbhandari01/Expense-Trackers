package com.chetanbhandari.expensemanager.feature.export

import androidx.compose.runtime.Stable
import com.chetanbhandari.expensemanager.core.designsystem.ui.utils.UiText
import com.chetanbhandari.expensemanager.core.model.AccountUiModel
import com.chetanbhandari.expensemanager.core.model.DateRangeType
import com.chetanbhandari.expensemanager.core.model.ExportFileType

@Stable
data class ExportState(
    val isLoading: Boolean,
    val selectedDateRange: DateRangeType,
    val selectedDateRangeText: UiText,
    val selectedAccounts: List<AccountUiModel>,
    val fileType: ExportFileType,
    val accountCount: UiText,
    val isAllAccountSelected: Boolean,
    val showAccountSelection: Boolean,
)
