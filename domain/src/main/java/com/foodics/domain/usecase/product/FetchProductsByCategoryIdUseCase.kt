package com.foodics.domain.usecase.product

import com.foodics.domain.model.remote.response.ProductRemoteResponse
import com.foodics.domain.repository.product.ProductRepository


class FetchProductsByCategoryIdUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(
        categoryId: String,
        forceRefresh: Boolean = false
    ): List<ProductRemoteResponse> {
        val localData = productRepository.getProductsByCategory(
            categoryId = categoryId,
            forceRefresh = forceRefresh
        )
        if (localData.isEmpty()) {
            productRepository.refreshProducts()
            return productRepository.getProductsByCategory(categoryId)
        }
        return localData
    }
}