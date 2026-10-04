package com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.daterange

import com.chetanbhandari.expensemanager.core.model.DateRangeType
import com.chetanbhandari.expensemanager.core.model.GroupType
import com.chetanbhandari.expensemanager.core.repository.DateRangeFilterRepository

class GetTransactionGroupTypeUseCase(
    private val dateRangeFilterRepository: DateRangeFilterRepository,
) {

    suspend operator fun invoke(dateRangeType: DateRangeType): GroupType = dateRangeFilterRepository.getTransactionGroupType(dateRangeType)
}
