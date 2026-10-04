package com.chetanbhandari.expensemanager.feature.account.di

import com.chetanbhandari.expensemanager.feature.account.create.AccountCreateViewModel
import com.chetanbhandari.expensemanager.feature.account.list.AccountListViewModel
import com.chetanbhandari.expensemanager.feature.account.reorder.AccountReOrderViewModel
import com.chetanbhandari.expensemanager.feature.account.selection.AccountSelectionViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val AccountViewModelModule = module {
    viewModel {
        AccountCreateViewModel(
            savedStateHandle = get(),
            getCurrencyUseCase = get(),
            getDefaultCurrencyUseCase = get(),
            getFormattedAmountUseCase = get(),
            findAccountByIdUseCase = get(),
            addAccountUseCase = get(),
            updateAccountUseCase = get(),
            deleteAccountUseCase = get(),
            imageStorageRepository = get(),
            composeNavigator = get(),
            numberFormatRepository = get(),
            analyticsRepository = get(),
        )
    }
    viewModel {
        AccountSelectionViewModel(
            getCurrencyUseCase = get(),
            getFormattedAmountUseCase = get(),
            getAllAccountsUseCase = get(),
        )
    }
    viewModel {
        AccountListViewModel(
            getAllAccountsUseCase = get(),
            getCurrencyUseCase = get(),
            getFormattedAmountUseCase = get(),
            appComposeNavigator = get(),
        )
    }
    viewModel {
        AccountReOrderViewModel(
            getAllAccountsUseCase = get(),
            updateAllAccountUseCase = get(),
            appComposeNavigator = get(),
        )
    }
}
