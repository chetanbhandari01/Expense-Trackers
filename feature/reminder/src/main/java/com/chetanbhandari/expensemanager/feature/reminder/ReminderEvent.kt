package com.chetanbhandari.expensemanager.feature.reminder

sealed class ReminderEvent {

    data object RequestPermission : ReminderEvent()

    data object OpenSettings : ReminderEvent()
}
