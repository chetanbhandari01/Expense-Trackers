package com.chetanbhandari.expensemanager.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chetanbhandari.expensemanager.core.database.dao.AccountDao
import com.chetanbhandari.expensemanager.core.database.dao.BudgetDao
import com.chetanbhandari.expensemanager.core.database.dao.CategoryDao
import com.chetanbhandari.expensemanager.core.database.dao.TransactionDao
import com.chetanbhandari.expensemanager.core.database.entity.AccountEntity
import com.chetanbhandari.expensemanager.core.database.entity.BudgetAccountEntity
import com.chetanbhandari.expensemanager.core.database.entity.BudgetCategoryEntity
import com.chetanbhandari.expensemanager.core.database.entity.BudgetEntity
import com.chetanbhandari.expensemanager.core.database.entity.CategoryEntity
import com.chetanbhandari.expensemanager.core.database.entity.TransactionAttachmentEntity
import com.chetanbhandari.expensemanager.core.database.entity.TransactionEntity
import com.chetanbhandari.expensemanager.core.database.utils.AccountTypeConverter
import com.chetanbhandari.expensemanager.core.database.utils.CategoryTypeConverter
import com.chetanbhandari.expensemanager.core.database.utils.DateConverter
import com.chetanbhandari.expensemanager.core.database.utils.TransactionTypeConverter

/**
 * The Room database for this app
 */
@Database(
    entities = [
        CategoryEntity::class,
        TransactionEntity::class,
        AccountEntity::class,
        BudgetEntity::class,
        BudgetCategoryEntity::class,
        BudgetAccountEntity::class,
        TransactionAttachmentEntity::class,
    ],
    version = 8,
    exportSchema = true,
)
@TypeConverters(
    DateConverter::class,
    TransactionTypeConverter::class,
    CategoryTypeConverter::class,
    AccountTypeConverter::class,
)
abstract class ExpenseManagerDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    abstract fun transactionDao(): TransactionDao

    abstract fun accountDao(): AccountDao

    abstract fun budgetDao(): BudgetDao
}
