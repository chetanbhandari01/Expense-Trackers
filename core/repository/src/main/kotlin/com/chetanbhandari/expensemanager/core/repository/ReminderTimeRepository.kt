package com.chetanbhandari.expensemanager.core.repository

import com.chetanbhandari.expensemanager.core.model.ReminderTimeState
import com.chetanbhandari.expensemanager.core.model.Resource
import kotlinx.coroutines.flow.Flow

interface ReminderTimeRepository {

    suspend fun saveReminderTime(reminderTime: ReminderTimeState): Boolean

    fun getReminderTime(): Flow<ReminderTimeState>

    fun isReminderOn(): Flow<Boolean>

    suspend fun setReminderOn(reminder: Boolean): Resource<Boolean>

    /** True once the in-app explainer before the notification permission has been answered. */
    fun isNotificationPrimerShown(): Flow<Boolean>

    suspend fun setNotificationPrimerShown()
}
