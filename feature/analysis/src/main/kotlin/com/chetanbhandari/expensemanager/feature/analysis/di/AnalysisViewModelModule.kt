package com.chetanbhandari.expensemanager.feature.analysis.di

import com.chetanbhandari.expensemanager.feature.analysis.AnalysisScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val AnalysisViewModelModule = module {
    viewModel {
        AnalysisScreenViewModel(
            getCurrentThemeUseCase = get(),
            getChartDataUseCase = get(),
            getAverageDataUseCase = get(),
            getAmountStateUseCase = get(),
            getDateRangeUseCase = get(),
            settingsRepository = get(),
        )
    }
    viewModel {
        com.chetanbhandari.expensemanager.feature.analysis.AiAnalysisViewModel(
            getTransactionWithFilterUseCase = get(),
            getBudgetsUseCase = get(),
            getCurrencyUseCase = get(),
            getDateRangeUseCase = get(),
            ollamaRepository = get(),
            dispatchers = get(),
        )
    }
}
