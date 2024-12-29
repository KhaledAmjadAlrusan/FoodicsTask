package com.foodics.domain.repository.cart

import com.foodics.domain.model.db.CartEntity

interface CartRepository {
    suspend fun getCartItems(): List<CartEntity>
    suspend fun clearCart()
    suspend fun deleteItem(productId: String)
    suspend fun insertItem(cartEntity: CartEntity)
    suspend fun updateItemQuantity(productId: String, quantity: Int)
}