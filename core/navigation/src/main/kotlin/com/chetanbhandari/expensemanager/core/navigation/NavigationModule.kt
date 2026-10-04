package com.chetanbhandari.expensemanager.core.navigation

import org.koin.dsl.module

val NavigationModule = module {
    single<AppComposeNavigator> { ExpenseManagerComposeNavigator() }
}
