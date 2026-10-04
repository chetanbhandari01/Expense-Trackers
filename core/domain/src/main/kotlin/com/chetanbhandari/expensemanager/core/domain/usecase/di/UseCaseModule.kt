package com.chetanbhandari.expensemanager.core.domain.usecase.di

import com.chetanbhandari.expensemanager.core.domain.usecase.account.AccountUseCaseModule
import com.chetanbhandari.expensemanager.core.domain.usecase.budget.BudgetUseCaseModule
import com.chetanbhandari.expensemanager.core.domain.usecase.category.CategoryUseCaseModule
import com.chetanbhandari.expensemanager.core.domain.usecase.country.CountryUseCaseModule
import com.chetanbhandari.expensemanager.core.domain.usecase.settings.SettingsUseCaseModule
import com.chetanbhandari.expensemanager.core.domain.usecase.settings.filter.FilterUseCaseModule
import com.chetanbhandari.expensemanager.core.domain.usecase.transaction.TransactionUseCaseModule
import org.koin.dsl.module

val UseCaseModule = module {
    includes(
        AccountUseCaseModule,
        BudgetUseCaseModule,
        CategoryUseCaseModule,
        CountryUseCaseModule,
        SettingsUseCaseModule,
        TransactionUseCaseModule,
        FilterUseCaseModule,
    )
}
