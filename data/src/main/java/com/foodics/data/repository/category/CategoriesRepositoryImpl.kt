package com.foodics.data.repository.category

import com.foodics.data.datasource.category.CategoryDataSource
import com.foodics.data.db.dao.CategoryDao
import com.foodics.domain.mapper.toDomain
import com.foodics.domain.mapper.toEntity
import com.foodics.domain.model.remote.response.CategoryRemoteResponse
import com.foodics.domain.repository.category.CategoriesRepository

class CategoriesRepositoryImpl(
    private val categoryDataSource: CategoryDataSource,
    private val categoryDao: CategoryDao
) : CategoriesRepository {
    override suspend fun getCategories(forceRefresh: Boolean): List<CategoryRemoteResponse> {
        if (forceRefresh) {
            return refreshCategories()
        }
        return categoryDao.getAllCategories().map { it.toDomain() }
    }

    override suspend fun refreshCategories(): List<CategoryRemoteResponse> {
        val remoteCategories = categoryDataSource.fetchCategories()
        categoryDao.insertAll(remoteCategories.map { it.toEntity() })
        return remoteCategories
    }
}