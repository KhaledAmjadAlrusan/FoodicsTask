package com.foodics.domain.usecase.cart

import com.foodics.domain.enum.QuantityAction
import com.foodics.domain.mapper.toCartEntity
import com.foodics.domain.repository.cart.CartRepository
import com.foodics.domain.repository.product.ProductRepository


class UpdateItemQuantityUseCase(
    private val cartRepository: CartRepository,
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(productId: String, action: QuantityAction) {
        val currentItems = cartRepository.getCartItems()
        val product = productRepository.getProductById(productId)

        val item = currentItems.find { it.productId == product.id }
        if (item != null) {
            val newQuantity = when (action) {
                QuantityAction.Increase -> item.quantity + 1
                QuantityAction.Decrease -> item.quantity - 1
            }
            if (newQuantity > 0) {
                cartRepository.updateItemQuantity(product.id, newQuantity)
            } else {
                cartRepository.deleteItem(product.id)
            }
        } else {
            if (action == QuantityAction.Increase) {
                cartRepository.insertItem(product.toCartEntity(1))
            }
        }
    }
}
