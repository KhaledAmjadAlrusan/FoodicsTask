package com.foodics.data.di

import com.foodics.data.datasource.category.CategoryDataSource
import com.foodics.data.datasource.category.CategoryDataSourceImpl
import com.foodics.data.datasource.product.ProductDataSource
import com.foodics.data.datasource.product.ProductDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    factory<CategoryDataSource> { CategoryDataSourceImpl(get()) }
    factory<ProductDataSource> { ProductDataSourceImpl(get()) }
}