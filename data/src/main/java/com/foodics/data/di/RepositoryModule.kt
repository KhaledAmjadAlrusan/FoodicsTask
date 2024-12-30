package com.foodics.data.di

import com.foodics.data.repository.cart.CartRepositoryImpl
import com.foodics.data.repository.category.CategoriesRepositoryImpl
import com.foodics.data.repository.product.ProductRepositoryImpl
import com.foodics.domain.repository.cart.CartRepository
import com.foodics.domain.repository.category.CategoriesRepository
import com.foodics.domain.repository.product.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<CategoriesRepository> { CategoriesRepositoryImpl(get(), get()) }
    factory<ProductRepository> { ProductRepositoryImpl(get(), get()) }
    factory<CartRepository> { CartRepositoryImpl(get()) }
}