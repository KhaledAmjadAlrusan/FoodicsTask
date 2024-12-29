package com.foodics.domain.model.local.cart

data class CartTableItem(
    val productQuantity: List<Pair<String, Int>> = emptyList(),
    val totalPrice: Double = 0.0,
    val totalQuantity: Int = 0
)