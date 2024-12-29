package com.foodics.domain.di

import com.foodics.domain.usecase.cart.ClearCartUseCase
import com.foodics.domain.usecase.cart.GetCartItemsUseCase
import com.foodics.domain.usecase.cart.UpdateItemQuantityUseCase
import com.foodics.domain.usecase.category.FetchCategoriesUseCase
import com.foodics.domain.usecase.product.FetchProductsByCategoryIdUseCase
import com.foodics.domain.usecase.product.FetchProductsUseCase
import com.foodics.domain.usecase.product.GetProductById
import org.koin.dsl.module


val useCaseModule = module {
    //Product
    factory { FetchProductsByCategoryIdUseCase(get()) }
    factory { FetchProductsUseCase(get()) }
    factory { GetProductById(get()) }

    //Category
    factory { FetchCategoriesUseCase(get()) }

    //Cart
    factory { ClearCartUseCase(get()) }
    factory { GetCartItemsUseCase(get()) }
    factory { UpdateItemQuantityUseCase(get(), get()) }
}

