package com.chetanbhandari.expensemanager.core.domain.usecase.account

import com.chetanbhandari.expensemanager.core.model.Account
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.AccountRepository

class FindAccountByIdUseCase(private val repository: AccountRepository) {

    suspend operator fun invoke(accountId: String?): Resource<Account> {
        if (accountId.isNullOrBlank()) {
            return Resource.Error(Exception("Provide valid account id value"))
        }

        return repository.findAccount(accountId)
    }
}
