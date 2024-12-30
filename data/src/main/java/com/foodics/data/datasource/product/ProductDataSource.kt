package com.foodics.data.datasource.product

import com.foodics.domain.model.remote.response.ProductRemoteResponse


interface ProductDataSource {
    suspend fun fetchProducts(): List<ProductRemoteResponse>
}