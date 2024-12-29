package com.foodics.domain.usecase.product

import com.foodics.domain.model.remote.response.ProductRemoteResponse
import com.foodics.domain.repository.product.ProductRepository


class GetProductById(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productId: String): ProductRemoteResponse {
        return repository.getProductById(productId)
    }
}