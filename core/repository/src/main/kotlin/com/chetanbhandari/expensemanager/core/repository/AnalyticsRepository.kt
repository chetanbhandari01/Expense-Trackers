package com.chetanbhandari.expensemanager.core.repository

interface AnalyticsRepository {

    fun trackAppOpenEvent()

    fun logEvent(eventName: String, params: Map<String, String>)

    fun setCurrentScreen(screenName: String)

    fun setUserProperties()
}
