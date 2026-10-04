package com.chetanbhandari.expensemanager.feature.account.reorder

import com.chetanbhandari.expensemanager.core.model.Account

data class AccountReOrderState(
    val accounts: List<Account>,
    val showSaveButton: Boolean,
)
