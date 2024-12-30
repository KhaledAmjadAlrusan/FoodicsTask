package com.foodics.domain.usecase.product

import com.foodics.domain.model.remote.response.ProductRemoteResponse
import com.foodics.domain.repository.product.ProductRepository


class FetchProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean = false): List<ProductRemoteResponse> {
        return productRepository.getProducts(forceRefresh = forceRefresh)
    }
}