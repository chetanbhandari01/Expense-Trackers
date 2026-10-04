package com.chetanbhandari.expensemanager.feature.filter.datefilter

sealed class DateFilterEvent {

    data object Saved : DateFilterEvent()
}
