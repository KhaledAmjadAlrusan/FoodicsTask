package com.foodics.domain.mapper

import com.foodics.domain.model.db.CartEntity
import com.foodics.domain.model.db.ProductEntity
import com.foodics.domain.model.local.product.ProductTableItem
import com.foodics.domain.model.remote.response.CategoryRemoteResponse
import com.foodics.domain.model.remote.response.ProductRemoteResponse

fun ProductRemoteResponse.toEntity(): ProductEntity = ProductEntity(
    id = id,
    name = name,
    description = description,
    price = price,
    image = image,
    categoryId = category.id
)

fun ProductEntity.toDomain(): ProductRemoteResponse = ProductRemoteResponse(
    id = id,
    name = name,
    description = description,
    price = price,
    image = image,
    category = CategoryRemoteResponse(id = categoryId, name = "")
)

fun ProductEntity.toCartEntity(quantity: Int): CartEntity = CartEntity(
    productId = id,
    name = name,
    price = price,
    image = image,
    quantity = quantity
)

fun ProductRemoteResponse.toCartEntity(quantity: Int): CartEntity = CartEntity(
    productId = id,
    name = name,
    price = price,
    image = image,
    quantity = quantity
)

fun ProductRemoteResponse.toProductTableItem(quantity: Int) = ProductTableItem(
    productRemoteResponse = this,
    quantity = quantity
)