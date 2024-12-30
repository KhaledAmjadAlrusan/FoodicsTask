package com.foodics.foodicstask.di

import com.foodics.core.di.networkConfigModule
import com.foodics.data.di.dataSourceModule
import com.foodics.data.di.dbModule
import com.foodics.data.di.repositoryModule
import com.foodics.domain.di.useCaseModule
import com.foodics.presentation.di.viewModelModule

val appModules = listOf(
    networkConfigModule,
    dataSourceModule,
    dbModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)
