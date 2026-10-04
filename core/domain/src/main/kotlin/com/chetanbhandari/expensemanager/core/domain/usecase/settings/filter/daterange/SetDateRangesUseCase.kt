package com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.daterange

import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.DateRangeFilterRepository
import java.util.Date

class SetDateRangesUseCase(
    private val dateRangeFilterRepository: DateRangeFilterRepository,
) {

    suspend operator fun invoke(customDateRange: List<Date>): Resource<Boolean> = dateRangeFilterRepository.setDateRanges(customDateRange)
}
