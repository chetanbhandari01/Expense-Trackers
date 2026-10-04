package com.chetanbhandari.expensemanager.core.domain.usecase.settings.reminder

import com.chetanbhandari.expensemanager.core.repository.ReminderTimeRepository
import kotlinx.coroutines.flow.Flow

class GetReminderStatusUseCase(private val repository: ReminderTimeRepository) {
    operator fun invoke(): Flow<Boolean> = repository.isReminderOn()
}
