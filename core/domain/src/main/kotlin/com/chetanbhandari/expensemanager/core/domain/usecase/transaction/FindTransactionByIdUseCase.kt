package com.chetanbhandari.expensemanager.core.domain.usecase.transaction

import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.model.Transaction
import com.chetanbhandari.expensemanager.core.repository.TransactionRepository

class FindTransactionByIdUseCase(
    private val repository: TransactionRepository,
) {
    suspend fun invoke(id: String?): Resource<Transaction> {
        if (id.isNullOrEmpty()) {
            return Resource.Error(KotlinNullPointerException("Id shouldn't be null"))
        }
        return repository.findTransactionById(id)
    }
}
