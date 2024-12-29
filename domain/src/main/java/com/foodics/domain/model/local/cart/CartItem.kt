package com.foodics.domain.model.local.cart

data class CartItem(
    val productId: String,
    val name: String,
    val price: Double,
    val image: String,
    val quantity: Int
)