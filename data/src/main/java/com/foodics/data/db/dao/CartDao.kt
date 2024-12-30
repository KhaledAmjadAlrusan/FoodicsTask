package com.foodics.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.foodics.domain.model.db.CartEntity

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(cartItem: CartEntity)

    @Query("SELECT * FROM cart_items")
    suspend fun getCartItems(): List<CartEntity>

    @Query("UPDATE cart_items SET quantity = :quantity WHERE productId = :itemId")
    suspend fun updateItemQuantity(itemId: String, quantity: Int)

    @Query("DELETE FROM cart_items WHERE productId = :itemId")
    suspend fun deleteItem(itemId: String)

    @Query("DELETE FROM cart_items")
    suspend fun clearCart()
}
