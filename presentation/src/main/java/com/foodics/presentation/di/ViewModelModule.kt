package com.foodics.presentation.di

import com.foodics.presentation.feature.tables.viewmodel.TablesScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        TablesScreenViewModel(get(), get(), get(), get(), get(), get())
    }
}
