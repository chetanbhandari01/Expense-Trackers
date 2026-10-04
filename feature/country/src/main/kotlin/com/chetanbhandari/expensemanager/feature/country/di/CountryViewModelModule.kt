package com.chetanbhandari.expensemanager.feature.country.di

import com.chetanbhandari.expensemanager.feature.country.CountryListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val CountryViewModelModule = module {
    viewModel {
        CountryListViewModel(getCountriesUseCase = get())
    }
}
