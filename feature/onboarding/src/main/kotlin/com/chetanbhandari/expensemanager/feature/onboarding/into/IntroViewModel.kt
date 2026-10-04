package com.chetanbhandari.expensemanager.feature.onboarding.into

import androidx.lifecycle.ViewModel
import com.chetanbhandari.expensemanager.core.navigation.AppComposeNavigator
import com.chetanbhandari.expensemanager.core.navigation.ExpenseManagerScreens
import com.chetanbhandari.expensemanager.core.repository.AnalyticsEvents
import com.chetanbhandari.expensemanager.core.repository.AnalyticsRepository

class IntroViewModel(
    private val appComposeNavigator: AppComposeNavigator,
    private val analyticsRepository: AnalyticsRepository,
) : ViewModel() {

    fun navigate() {
        analyticsRepository.logEvent(AnalyticsEvents.INTRO_GET_STARTED, emptyMap())
        appComposeNavigator.navigate(ExpenseManagerScreens.Onboarding)
    }
}
