package com.chetanbhandari.expensemanager.core.domain.usecase.settings.onboarding

import com.chetanbhandari.expensemanager.core.repository.SettingsRepository
import kotlinx.coroutines.flow.first

class GetPreloadStatusUseCase(private val repository: SettingsRepository) {
    suspend operator fun invoke(): Boolean = repository.isPreloaded().first()
}
