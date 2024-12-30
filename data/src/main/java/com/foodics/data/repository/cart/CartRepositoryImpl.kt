package com.foodics.data.repository.cart

import com.foodics.data.db.dao.CartDao
import com.foodics.domain.model.db.CartEntity
import com.foodics.domain.repository.cart.CartRepository

class CartRepositoryImpl(
    private val cartDao: CartDao
) : CartRepository {

    override suspend fun getCartItems(): List<CartEntity> {
        return cartDao.getCartItems()
    }

    override suspend fun clearCart() {
        cartDao.clearCart()
    }

    override suspend fun updateItemQuantity(productId: String, quantity: Int) {
        cartDao.updateItemQuantity(productId, quantity)
    }

    override suspend fun deleteItem(productId: String) {
        cartDao.deleteItem(productId)
    }

    override suspend fun insertItem(cartEntity: CartEntity) {
        cartDao.insertItem(cartEntity)
    }
}
