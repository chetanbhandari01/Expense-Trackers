package com.chetanbhandari.expensemanager.feature.export.di

import com.chetanbhandari.expensemanager.feature.export.ExportViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val ExportViewModelModule = module {
    viewModel {
        ExportViewModel(
            getDateRangeUseCase = get(),
            exportFileUseCase = get(),
            appComposeNavigator = get(),
            analyticsRepository = get(),
        )
    }
}
