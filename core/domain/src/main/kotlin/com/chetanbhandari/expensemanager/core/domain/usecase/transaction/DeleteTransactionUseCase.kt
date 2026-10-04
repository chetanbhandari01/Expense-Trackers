package com.chetanbhandari.expensemanager.core.domain.usecase.transaction

import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.model.Transaction
import com.chetanbhandari.expensemanager.core.repository.TransactionRepository

class DeleteTransactionUseCase(
    private val repository: TransactionRepository,
) {

    suspend operator fun invoke(transaction: Transaction): Resource<Boolean> {
        if (transaction.id.isBlank()) {
            return Resource.Error(Exception("ID shouldn't be blank"))
        }

        if (transaction.categoryId.isBlank()) {
            return Resource.Error(Exception("Category type shouldn't be blank"))
        }

        if (transaction.fromAccountId.isBlank()) {
            return Resource.Error(Exception("From account shouldn't be blank"))
        }

        return repository.deleteTransaction(transaction)
    }
}
