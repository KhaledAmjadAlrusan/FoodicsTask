package com.foodics.domain.repository.product

import com.foodics.domain.model.remote.response.ProductRemoteResponse


interface ProductRepository {
    suspend fun getProducts(forceRefresh: Boolean = false): List<ProductRemoteResponse>
    suspend fun getProductsByCategory(
        categoryId: String,
        forceRefresh: Boolean = false
    ): List<ProductRemoteResponse>

    suspend fun getProductById(productId: String): ProductRemoteResponse
    suspend fun refreshProducts()
}