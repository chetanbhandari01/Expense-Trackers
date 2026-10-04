package com.chetanbhandari.expensemanager.feature.language.di

import com.chetanbhandari.expensemanager.feature.language.LanguageViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val LanguageViewModelModule = module {
    viewModel {
        LanguageViewModel(
            getCurrentLocaleUseCase = get(),
            getLocalesUseCase = get(),
            saveLocaleUseCase = get(),
        )
    }
}
