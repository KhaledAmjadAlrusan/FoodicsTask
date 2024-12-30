package com.foodics.data.datasource.product

import com.foodics.data.datasource.Endpoints
import com.foodics.domain.model.remote.response.ProductRemoteResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProductDataSourceImpl(
    private val client: HttpClient
) : ProductDataSource {
    override suspend fun fetchProducts(): List<ProductRemoteResponse> {
        return client.get(Endpoints.GetProducts.path).body()
    }
}
