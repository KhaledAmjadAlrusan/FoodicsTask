package com.foodics.domain.repository.category

import com.foodics.domain.model.remote.response.CategoryRemoteResponse


interface CategoriesRepository {
    suspend fun getCategories(forceRefresh: Boolean = false): List<CategoryRemoteResponse>

    suspend fun refreshCategories(): List<CategoryRemoteResponse>
}