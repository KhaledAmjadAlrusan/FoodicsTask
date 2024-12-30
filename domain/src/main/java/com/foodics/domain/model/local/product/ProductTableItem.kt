package com.foodics.domain.model.local.product

import com.foodics.domain.model.remote.response.ProductRemoteResponse


data class ProductTableItem(
    val productRemoteResponse: ProductRemoteResponse,
    val quantity: Int
)