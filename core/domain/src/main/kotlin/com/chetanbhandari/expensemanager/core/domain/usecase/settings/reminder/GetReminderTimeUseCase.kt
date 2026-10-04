package com.chetanbhandari.expensemanager.core.domain.usecase.settings.reminder

import com.chetanbhandari.expensemanager.core.model.ReminderTimeState
import com.chetanbhandari.expensemanager.core.repository.ReminderTimeRepository
import kotlinx.coroutines.flow.Flow

class GetReminderTimeUseCase(
    private val repository: ReminderTimeRepository,
) {
    operator fun invoke(): Flow<ReminderTimeState> = repository.getReminderTime()
}
