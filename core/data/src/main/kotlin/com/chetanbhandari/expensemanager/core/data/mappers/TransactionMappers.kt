package com.chetanbhandari.expensemanager.core.data.mappers

import com.chetanbhandari.expensemanager.core.database.entity.TransactionEntity
import com.chetanbhandari.expensemanager.core.model.Amount
import com.chetanbhandari.expensemanager.core.model.Transaction

fun Transaction.toEntityModel(): TransactionEntity = TransactionEntity(
    id = id,
    notes = notes,
    categoryId = categoryId,
    fromAccountId = fromAccountId,
    toAccountId = toAccountId,
    type = type,
    amount = amount.amount,
    imagePath = imagePath,
    createdOn = createdOn,
    updatedOn = updatedOn,
)

fun TransactionEntity.toDomainModel(): Transaction = Transaction(
    id = id,
    notes = notes,
    categoryId = categoryId,
    fromAccountId = fromAccountId,
    toAccountId = toAccountId,
    type = type,
    amount = Amount(amount),
    imagePath = imagePath,
    createdOn = createdOn,
    updatedOn = updatedOn,
)
