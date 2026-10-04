package com.chetanbhandari.expensemanager.feature.theme.di

import com.chetanbhandari.expensemanager.feature.theme.ThemeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val ThemeViewModelModule = module {
    viewModel {
        ThemeViewModel(
            getSelectedTheme = get(),
            getThemesUseCase = get(),
            saveThemeUseCase = get(),
        )
    }
}
