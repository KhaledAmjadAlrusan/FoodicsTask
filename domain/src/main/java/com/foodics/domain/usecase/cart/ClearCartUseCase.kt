package com.foodics.domain.usecase.cart

import com.foodics.domain.repository.cart.CartRepository


class ClearCartUseCase(private val repository: CartRepository) {
    suspend operator fun invoke() {
        repository.clearCart()
    }
}
