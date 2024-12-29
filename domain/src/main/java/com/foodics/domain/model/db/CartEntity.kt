package com.foodics.domain.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartEntity(
    @PrimaryKey val productId: String,
    val name: String,
    val price: Double,
    val image: String,
    val quantity: Int
)
