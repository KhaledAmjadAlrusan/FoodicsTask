package com.foodics.domain.model.remote.response

import kotlinx.serialization.Serializable


@Serializable
data class ProductRemoteResponse(
    val id: String,
    val name: String,
    val description: String?,
    val price: Double,
    val image: String,
    val category: CategoryRemoteResponse
)
