package com.chetanbhandari.expensemanager.feature.account.list

import androidx.compose.runtime.Stable
import com.chetanbhandari.expensemanager.core.model.AccountUiModel
import com.chetanbhandari.expensemanager.core.model.Amount

@Stable
data class AccountListState(
    val showReOrder: Boolean,
    val accounts: List<AccountUiModel>,
    // Sum of all positive balances.
    val assetsAmount: Amount? = null,
    // Sum of all negative balances (credit spend / overdrawn), shown as a positive value.
    val liabilitiesAmount: Amount? = null,
    // Net of every balance: assets - liabilities.
    val totalAmount: Amount? = null,
    val totalAmountTextColor: Int? = null,
)
