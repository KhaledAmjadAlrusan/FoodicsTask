package com.foodics.data.repository.product

import com.foodics.data.datasource.product.ProductDataSource
import com.foodics.data.db.dao.ProductDao
import com.foodics.domain.mapper.toDomain
import com.foodics.domain.mapper.toEntity
import com.foodics.domain.model.remote.response.ProductRemoteResponse
import com.foodics.domain.repository.product.ProductRepository

class ProductRepositoryImpl(
    private val productDataSource: ProductDataSource,
    private val productDao: ProductDao
) : ProductRepository {
    override suspend fun getProducts(forceRefresh: Boolean): List<ProductRemoteResponse> {
        if (forceRefresh) {
            refreshProducts()
        }
        return productDao.getProducts().map { it.toDomain() }
    }

    override suspend fun getProductsByCategory(
        categoryId: String,
        forceRefresh: Boolean
    ): List<ProductRemoteResponse> {
        if (forceRefresh) {
            refreshProducts()
        }
        return productDao.getProductsByCategory(categoryId).map { it.toDomain() }
    }

    override suspend fun getProductById(productId: String): ProductRemoteResponse {
        return productDao.getProductById(productId).toDomain()
    }

    override suspend fun refreshProducts() {
        val remoteProducts = productDataSource.fetchProducts()
        productDao.insertAll(remoteProducts.map { it.toEntity() })
    }
}