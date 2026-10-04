package com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.daterange

import com.chetanbhandari.expensemanager.core.model.DateRangeModel
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.DateRangeFilterRepository

class GetAllDateRangeUseCase(
    private val dateRangeFilterRepository: DateRangeFilterRepository,
) {
    suspend operator fun invoke(): Resource<List<DateRangeModel>> = dateRangeFilterRepository.getAllDateRanges()
}
