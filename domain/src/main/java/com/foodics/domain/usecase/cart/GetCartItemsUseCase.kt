package com.foodics.domain.usecase.cart

import com.foodics.domain.mapper.toDomain
import com.foodics.domain.model.local.cart.CartItem
import com.foodics.domain.repository.cart.CartRepository


class GetCartItemsUseCase(private val repository: CartRepository) {
    suspend operator fun invoke(): List<CartItem> {
        return repository.getCartItems().map { it.toDomain() }
    }
}
