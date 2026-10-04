package com.chetanbhandari.expensemanager.core.domain.usecase.settings.reminder

import com.chetanbhandari.expensemanager.core.repository.ReminderTimeRepository

class UpdateReminderStatusUseCase(
    private val repository: ReminderTimeRepository,
) {

    suspend operator fun invoke(reminderStatus: Boolean) {
        repository.setReminderOn(reminderStatus)
    }
}
