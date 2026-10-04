package com.chetanbhandari.expensemanager.feature.reminder

import androidx.compose.runtime.Composable
import com.chetanbhandari.expensemanager.core.designsystem.ui.components.AppTimePickerDialog
import com.chetanbhandari.expensemanager.core.model.ReminderTimeState

@Composable
fun ReminderTimePickerView(
    reminderTimeState: ReminderTimeState,
    onAction: (ReminderAction) -> Unit,
) {
    AppTimePickerDialog(
        reminderTimeState = Triple(
            reminderTimeState.hour,
            reminderTimeState.minute,
            reminderTimeState.is24Hour,
        ),
        onTimeSelected = {
            onAction.invoke(
                ReminderAction.SaveReminder(
                    reminderState = ReminderTimeState(it.first, it.second, it.third),
                ),
            )
        },
    ) {
        onAction.invoke(ReminderAction.CloseReminderDialog)
    }
}
