package com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.daterange

import com.chetanbhandari.expensemanager.core.common.utils.toCompleteDate
import com.chetanbhandari.expensemanager.core.model.DateRangeType
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.DateRangeFilterRepository
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class MoveDateRangeBackwardUseCase(
    private val dateRangeFilterRepository: DateRangeFilterRepository,
) {

    @OptIn(ExperimentalTime::class)
    suspend operator fun invoke(type: DateRangeType): Resource<Boolean> {
        val dateRangeModel = dateRangeFilterRepository.getDateRangeFilterTypeString(type)
        var startTime = Instant.fromEpochMilliseconds(dateRangeModel.dateRanges[0])
        var endTime = Instant.fromEpochMilliseconds(dateRangeModel.dateRanges[1])
        startTime = startTime.minusRespectiveFrame(type)
        endTime = endTime.minusRespectiveFrame(type)
        dateRangeFilterRepository.setDateRanges(
            listOf(
                startTime.toEpochMilliseconds().toCompleteDate(),
                endTime.toEpochMilliseconds().toCompleteDate(),
            ),
        )
        return Resource.Success(true)
    }
}
