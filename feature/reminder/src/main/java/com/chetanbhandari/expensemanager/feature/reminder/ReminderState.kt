package com.chetanbhandari.expensemanager.feature.reminder

import androidx.compose.runtime.Stable
import com.chetanbhandari.expensemanager.core.model.ReminderTimeState

@Stable
data class ReminderState(
    val reminderStatus: Boolean = false,
    val reminderTime: String = "06:00",
    val reminderTimeState: ReminderTimeState = ReminderTimeState(6, 0, false),
    val showTimePickerDialog: Boolean = false,
    val shouldShowRationale: Boolean = false,
    val showPermissionMessage: Boolean = false,
)
