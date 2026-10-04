package com.chetanbhandari.expensemanager.core.model

enum class AccountType {
    REGULAR,
    CREDIT,
}

fun AccountType.isRegular() = this == AccountType.REGULAR

fun AccountType.isCredit() = this == AccountType.CREDIT
