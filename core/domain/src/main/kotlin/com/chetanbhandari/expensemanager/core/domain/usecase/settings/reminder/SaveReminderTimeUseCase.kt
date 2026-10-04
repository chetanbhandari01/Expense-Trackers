package com.chetanbhandari.expensemanager.core.domain.usecase.settings.reminder

import com.chetanbhandari.expensemanager.core.model.ReminderTimeState
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.ReminderTimeRepository

class SaveReminderTimeUseCase(
    private val repository: ReminderTimeRepository,
) {
    suspend operator fun invoke(reminderTimeState: ReminderTimeState): Resource<Boolean> = Resource.Success(repository.saveReminderTime(reminderTimeState))
}
