package com.chetanbhandari.expensemanager.feature.filter.type

sealed class FilterTypeEvent {

    data object Saved : FilterTypeEvent()
}
