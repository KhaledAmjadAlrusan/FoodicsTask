package com.foodics.domain.model.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class CategoryRemoteResponse(
    val id: String,
    val name: String
)