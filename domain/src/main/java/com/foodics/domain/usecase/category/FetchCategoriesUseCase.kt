package com.foodics.domain.usecase.category

import com.foodics.domain.model.remote.response.CategoryRemoteResponse
import com.foodics.domain.repository.category.CategoriesRepository


class FetchCategoriesUseCase(
    private val categoriesRepository: CategoriesRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean = false): List<CategoryRemoteResponse> {
        val localData = categoriesRepository.getCategories(forceRefresh = forceRefresh)
        if (localData.isEmpty()) {
            return categoriesRepository.refreshCategories()
        }
        return localData
    }
}