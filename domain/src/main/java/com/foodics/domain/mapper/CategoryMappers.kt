package com.foodics.domain.mapper

import com.foodics.domain.model.db.CategoryEntity
import com.foodics.domain.model.remote.response.CategoryRemoteResponse

fun CategoryRemoteResponse.toEntity(): CategoryEntity = CategoryEntity(
    id = id,
    name = name
)

fun CategoryEntity.toDomain(): CategoryRemoteResponse = CategoryRemoteResponse(
    id = id,
    name = name
)
