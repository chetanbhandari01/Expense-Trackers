package com.chetanbhandari.expensemanager.feature.filter.datefilter

import androidx.compose.runtime.Stable
import com.chetanbhandari.expensemanager.core.model.DateRangeModel
import com.chetanbhandari.expensemanager.core.model.DateRangeType
import com.chetanbhandari.expensemanager.core.model.TextFieldValue
import java.util.Date

@Stable
data class DateFilterState(
    val dateRangeType: TextFieldValue<DateRangeType>,
    val fromDate: TextFieldValue<Date>,
    val toDate: TextFieldValue<Date>,
    val dateRangeTypeList: List<DateRangeModel>,
    val showCustomRangeSelection: Boolean,
    val showDateFilter: Boolean,
    val dateFilterType: DateFilterType,
)
