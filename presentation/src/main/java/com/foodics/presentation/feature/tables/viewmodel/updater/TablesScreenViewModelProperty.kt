package com.foodics.presentation.feature.tables.viewmodel.updater

import com.foodics.domain.model.local.product.ProductTableItem
import com.foodics.domain.model.remote.response.ProductRemoteResponse
import com.foodics.presentation.feature.tables.viewmodel.TablesScreenViewModel

fun TablesScreenViewModel.getProductQuantity(productId: String): Int {
    return state.value.cartState.cartItems.productQuantity.find { it.first == productId }?.second
        ?: 0

}

fun TablesScreenViewModel.getAllProduct(): List<ProductRemoteResponse> {
    return state.value.productsState.allProducts
}

fun TablesScreenViewModel.getSelectedCategoryId(): String? {
    return state.value.categoriesState.selectedCategoryId
}

fun TablesScreenViewModel.getFilteredProducts(): List<ProductTableItem> {
    return state.value.productsState.filteredProducts
}