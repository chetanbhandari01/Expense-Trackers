package com.chetanbhandari.expensemanager.core.domain.usecase.account

import com.chetanbhandari.expensemanager.core.model.Account
import com.chetanbhandari.expensemanager.core.model.Resource
import com.chetanbhandari.expensemanager.core.repository.AccountRepository

class UpdateAccountUseCase(
    private val repository: AccountRepository,
    private val checkAccountValidationUseCase: CheckAccountValidationUseCase,
) {

    suspend operator fun invoke(account: Account): Resource<Boolean> = when (val validationResult = checkAccountValidationUseCase(account)) {
        is Resource.Error -> {
            validationResult
        }

        is Resource.Success -> {
            repository.updateAccount(account)
        }
    }
}
