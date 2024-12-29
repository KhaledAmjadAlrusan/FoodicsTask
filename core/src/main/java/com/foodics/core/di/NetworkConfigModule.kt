package com.foodics.core.di

import com.foodics.core.network.KtorClientFactory
import com.foodics.core.network.NetworkConfig

val networkConfigModule = org.koin.dsl.module {
    single { NetworkConfig(baseUrl = baseUrl) }
    single { KtorClientFactory(get()).createClient() }
}

private const val baseUrl = "https://my.api.mockaroo.com/"
