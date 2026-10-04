package com.chetanbhandari.expensemanager.feature.onboarding

import androidx.compose.runtime.Stable
import com.chetanbhandari.expensemanager.core.model.AccountUiModel
import com.chetanbhandari.expensemanager.core.model.Currency
import com.chetanbhandari.expensemanager.core.model.ReminderTimeState

@Stable
data class OnboardingState(
    val currency: Currency,
    val accounts: List<AccountUiModel>,
    val showCurrencySelection: Boolean,
    /** Daily reminder switch on the setup screen; on by default (matches the stored default). */
    val reminderEnabled: Boolean = true,
    /** Stored reminder time, shown on the card; null until loaded. */
    val reminderTime: ReminderTimeState? = null,
)
