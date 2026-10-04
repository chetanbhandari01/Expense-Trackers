package com.chetanbhandari.expensemanager.core.data.di

import com.chetanbhandari.expensemanager.core.data.repository.AccountRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.AnalyticsRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.BudgetRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.CategoryRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.CountryRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.CurrencyRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.DateRangeFilterRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.DevicePropertyRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.ExportRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.FeedbackRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.FirebaseSettingsRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.ImageStorageRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.JsonConverterRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.LocaleRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.ReminderTimeRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.SettingsRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.ShareRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.ThemeRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.TransactionRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.VersionCheckerRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.export.CsvExportStrategy
import com.chetanbhandari.expensemanager.core.data.repository.export.PdfExportStrategy
import com.chetanbhandari.expensemanager.core.repository.AccountRepository
import com.chetanbhandari.expensemanager.core.repository.AnalyticsRepository
import com.chetanbhandari.expensemanager.core.repository.BudgetRepository
import com.chetanbhandari.expensemanager.core.repository.CategoryRepository
import com.chetanbhandari.expensemanager.core.repository.CountryRepository
import com.chetanbhandari.expensemanager.core.repository.CurrencyRepository
import com.chetanbhandari.expensemanager.core.repository.DateRangeFilterRepository
import com.chetanbhandari.expensemanager.core.repository.DevicePropertyRepository
import com.chetanbhandari.expensemanager.core.repository.ExportRepository
import com.chetanbhandari.expensemanager.core.repository.FeedbackRepository
import com.chetanbhandari.expensemanager.core.repository.FirebaseSettingsRepository
import com.chetanbhandari.expensemanager.core.repository.ImageStorageRepository
import com.chetanbhandari.expensemanager.core.repository.JsonConverterRepository
import com.chetanbhandari.expensemanager.core.repository.LocaleRepository
import com.chetanbhandari.expensemanager.core.repository.ReminderTimeRepository
import com.chetanbhandari.expensemanager.core.repository.SettingsRepository
import com.chetanbhandari.expensemanager.core.repository.ShareRepository
import com.chetanbhandari.expensemanager.core.repository.ThemeRepository
import com.chetanbhandari.expensemanager.core.repository.TransactionRepository
import com.chetanbhandari.expensemanager.core.repository.VersionCheckerRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val RepositoryModule = module {
    single<ThemeRepository> {
        ThemeRepositoryImpl(
            dataStore = get(),
            versionCheckerRepository = get(),
            dispatchers = get(),
        )
    }
    single<LocaleRepository> {
        LocaleRepositoryImpl(
            dataStore = get(),
            dispatchers = get(),
        )
    }
    single<AnalyticsRepository> {
        AnalyticsRepositoryImpl(
            firebaseAnalytics = get(),
            devicePropertyRepository = get(),
        )
    }
    single<JsonConverterRepository> {
        JsonConverterRepositoryImpl(
            gson = get(),
            appCoroutineDispatchers = get(),
        )
    }
    single<CountryRepository> {
        CountryRepositoryImpl(
            context = androidContext(),
            jsonConverterRepository = get(),
            dispatchers = get(),
        )
    }
    single<CurrencyRepository> {
        CurrencyRepositoryImpl(
            dispatchers = get(),
            dataStore = get(),
            numberFormatRepository = get(),
        )
    }
    single<DevicePropertyRepository> { DevicePropertyRepositoryImpl(androidContext()) }
    single<FeedbackRepository> {
        FeedbackRepositoryImpl(
            context = androidContext(),
            feedbackDataStore = get(),
            firebaseCrashlytics = get(),
        )
    }
    single<FirebaseSettingsRepository> { FirebaseSettingsRepositoryImpl(firebaseRemoteConfig = get()) }
    single<ImageStorageRepository> { ImageStorageRepositoryImpl(context = androidContext()) }
    single<VersionCheckerRepository> { VersionCheckerRepositoryImpl() }

    single<AccountRepository> {
        AccountRepositoryImpl(
            accountDao = get(),
            dispatchers = get(),
        )
    }
    single<BudgetRepository> {
        BudgetRepositoryImpl(
            budgetDao = get(),
            dispatchers = get(),
        )
    }
    single<DateRangeFilterRepository> {
        DateRangeFilterRepositoryImpl(
            context = androidContext(),
            dataStore = get(),
            dispatcher = get(),
        )
    }
    single<ExportRepository> {
        ExportRepositoryImpl(
            dispatchers = get(),
            strategies = listOf(
                CsvExportStrategy(context = androidContext()),
                PdfExportStrategy(context = androidContext()),
            ),
        )
    }
    single<ReminderTimeRepository> {
        ReminderTimeRepositoryImpl(
            dataStore = get(),
            deviceLocalDataStore = get(),
            dispatchers = get(),
        )
    }
    single<SettingsRepository> {
        SettingsRepositoryImpl(
            dataStore = get(),
            dispatchers = get(),
        )
    }
    single<ShareRepository> {
        ShareRepositoryImpl(
            context = androidContext(),
            firebaseSettingsRepository = get(),
        )
    }
    single<TransactionRepository> {
        TransactionRepositoryImpl(
            transactionDao = get(),
            accountDao = get(),
            categoryDao = get(),
            dispatchers = get(),
        )
    }
    single<CategoryRepository> {
        CategoryRepositoryImpl(
            categoryDao = get(),
            dispatchers = get(),
        )
    }
    single<com.chetanbhandari.expensemanager.core.repository.OllamaRepository> {
        com.chetanbhandari.expensemanager.core.data.repository.OllamaRepositoryImpl(
            dispatchers = get()
        )
    }
}
