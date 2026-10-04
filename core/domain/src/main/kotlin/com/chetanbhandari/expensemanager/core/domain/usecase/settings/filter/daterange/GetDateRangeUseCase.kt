package com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.daterange

import com.chetanbhandari.expensemanager.core.model.DateRangeModel
import com.chetanbhandari.expensemanager.core.repository.DateRangeFilterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class GetDateRangeUseCase(
    private val getDateRangeByTypeUseCase: GetDateRangeByTypeUseCase,
    private val dateRangeFilterRepository: DateRangeFilterRepository,
) {

    operator fun invoke(): Flow<DateRangeModel> = combine(
        dateRangeFilterRepository.getDateRangeFilterType(),
        dateRangeFilterRepository.getDateRangeTimeFrame(),
    ) { type, _ ->
        getDateRangeByTypeUseCase.invoke(type)
    }
}
