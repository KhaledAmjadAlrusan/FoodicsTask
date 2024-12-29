package com.foodics.domain.mapper

import com.foodics.domain.model.db.CartEntity
import com.foodics.domain.model.local.cart.CartItem
import com.foodics.domain.model.local.cart.CartTableItem

fun CartEntity.toDomain(): CartItem = CartItem(productId, name, price, image, quantity)


fun List<CartItem>.toCartTableItem() = CartTableItem(
    productQuantity = map { it.productId to it.quantity },
    totalPrice = sumOf { it.quantity * it.price },
    totalQuantity = sumOf { it.quantity }
)