package com.chetanbhandari.expensemanager.core.domain.usecase.settings.onboarding

import com.chetanbhandari.expensemanager.core.repository.SettingsRepository

class SetOnboardingStatusUseCase(private val repository: SettingsRepository) {

    suspend operator fun invoke(onboardingCompleted: Boolean) {
        repository.setOnboardingCompleted(onboardingCompleted)
    }
}
