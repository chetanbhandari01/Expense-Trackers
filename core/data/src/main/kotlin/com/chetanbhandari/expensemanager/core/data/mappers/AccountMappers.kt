package com.chetanbhandari.expensemanager.core.data.mappers

import com.chetanbhandari.expensemanager.core.database.entity.AccountEntity
import com.chetanbhandari.expensemanager.core.model.Account
import com.chetanbhandari.expensemanager.core.model.StoredIcon

fun Account.toEntityModel(): AccountEntity = AccountEntity(
    id = id,
    name = name,
    type = type,
    iconBackgroundColor = storedIcon.backgroundColor,
    iconName = storedIcon.name,
    amount = amount,
    creditLimit = creditLimit,
    sequence = sequence,
    createdOn = createdOn,
    updatedOn = updatedOn,
    customImagePath = storedIcon.customImagePath,
)

fun AccountEntity.toDomainModel(): Account = Account(
    id = id,
    name = name,
    type = type,
    storedIcon = StoredIcon(
        name = iconName,
        backgroundColor = iconBackgroundColor,
        customImagePath = customImagePath,
    ),
    amount = amount,
    creditLimit = creditLimit,
    sequence = sequence,
    createdOn = createdOn,
    updatedOn = updatedOn,
)
