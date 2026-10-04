package com.chetanbhandari.expensemanager.di

import com.chetanbhandari.expensemanager.MainViewModel
import com.chetanbhandari.expensemanager.core.designsystem.components.CommonViewModelModule
import com.chetanbhandari.expensemanager.core.settings.di.CoreSettingsModule
import com.chetanbhandari.expensemanager.feature.about.di.AboutViewModelModule
import com.chetanbhandari.expensemanager.feature.account.di.AccountViewModelModule
import com.chetanbhandari.expensemanager.feature.analysis.di.AnalysisViewModelModule
import com.chetanbhandari.expensemanager.feature.budget.di.BudgetViewModelModule
import com.chetanbhandari.expensemanager.feature.category.di.CategoryViewModelModule
import com.chetanbhandari.expensemanager.feature.country.di.CountryViewModelModule
import com.chetanbhandari.expensemanager.feature.currency.di.CurrencyViewModelModule
import com.chetanbhandari.expensemanager.feature.dashboard.di.DashboardViewModelModule
import com.chetanbhandari.expensemanager.feature.export.di.ExportViewModelModule
import com.chetanbhandari.expensemanager.feature.filter.di.FilterViewModelModule
import com.chetanbhandari.expensemanager.feature.language.di.LanguageViewModelModule
import com.chetanbhandari.expensemanager.feature.onboarding.di.OnboardingViewModelModule
import com.chetanbhandari.expensemanager.feature.reminder.di.ReminderViewModelModule
import com.chetanbhandari.expensemanager.feature.settings.di.SettingsViewModelModule
import com.chetanbhandari.expensemanager.feature.theme.di.ThemeViewModelModule
import com.chetanbhandari.expensemanager.feature.transaction.di.TransactionViewModelModule
import com.chetanbhandari.expensemanager.ui.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val MainViewModelModule = module {
    viewModel {
        MainViewModel(
            getCurrentThemeUseCase = get(),
            getOnboardingStatusUseCase = get(),
            settingsRepository = get(),
            analyticsRepository = get(),
        )
    }
    viewModel {
        HomeViewModel(
            updateReminderStatusUseCase = get(),
            notificationScheduler = get(),
            analyticsRepository = get(),
            reminderTimeRepository = get(),
            feedbackRepository = get(),
            appComposeNavigator = get(),
        )
    }
}

val ViewModelModule = module {
    includes(
        MainViewModelModule,
        AccountViewModelModule,
        AnalysisViewModelModule,
        BudgetViewModelModule,
        CategoryViewModelModule,
        DashboardViewModelModule,
        TransactionViewModelModule,
        OnboardingViewModelModule,
        SettingsViewModelModule,
        ThemeViewModelModule,
        LanguageViewModelModule,
        ExportViewModelModule,
        ReminderViewModelModule,
        CurrencyViewModelModule,
        AboutViewModelModule,
        FilterViewModelModule,
        CountryViewModelModule,
        CommonViewModelModule,
        CoreSettingsModule,
    )
}
