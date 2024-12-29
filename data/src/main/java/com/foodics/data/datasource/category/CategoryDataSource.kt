package com.foodics.data.datasource.category

import com.foodics.domain.model.remote.response.CategoryRemoteResponse

interface CategoryDataSource {
    suspend fun fetchCategories(): List<CategoryRemoteResponse>
}
