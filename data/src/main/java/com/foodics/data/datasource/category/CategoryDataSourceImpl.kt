package com.foodics.data.datasource.category

import com.foodics.data.datasource.Endpoints
import com.foodics.domain.model.remote.response.CategoryRemoteResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CategoryDataSourceImpl(private val client: HttpClient) : CategoryDataSource {
    override suspend fun fetchCategories(): List<CategoryRemoteResponse> {
        return client.get(Endpoints.GetCategories.path).body()
    }
}
