package com.chetanbhandari.expensemanager.core.domain.usecase.account

import com.chetanbhandari.expensemanager.core.model.Account
import com.chetanbhandari.expensemanager.core.repository.AccountRepository
import kotlinx.coroutines.flow.Flow

class GetAllAccountsUseCase(private val repository: AccountRepository) {
    operator fun invoke(): Flow<List<Account>> = repository.getAccounts()
}
