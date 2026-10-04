package com.chetanbhandari.expensemanager.feature.currency.di

import com.chetanbhandari.expensemanager.feature.currency.CurrencyViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val CurrencyViewModelModule = module {
    viewModel {
        CurrencyViewModel(
            getDefaultCurrencyUseCase = get(),
            getCurrencyUseCase = get(),
            saveCurrencyUseCase = get(),
            appComposeNavigator = get(),
            numberFormatSettingRepository = get(),
        )
    }
}
