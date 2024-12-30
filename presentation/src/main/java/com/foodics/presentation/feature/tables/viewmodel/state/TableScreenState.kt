package com.foodics.presentation.feature.tables.viewmodel.state

import com.foodics.domain.model.local.cart.CartTableItem
import com.foodics.domain.model.local.product.ProductTableItem
import com.foodics.domain.model.remote.response.CategoryRemoteResponse
import com.foodics.domain.model.remote.response.ProductRemoteResponse

data class TablesScreenState(
    val categoriesState: CategoriesState = CategoriesState(),
    val productsState: ProductsState = ProductsState(),
    val cartState: CartState = CartState(),
    val searchState: SearchState = SearchState(),
    val error: Throwable? = null
)


data class CategoriesState(
    val categories: List<CategoryRemoteResponse> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCategoryId: String? = null
) {
    val isEmpty: Boolean get() = categories.isEmpty()
}

data class ProductsState(
    val filteredProducts: List<ProductTableItem> = emptyList(),
    val allProducts: List<ProductRemoteResponse> = emptyList(),
    val isLoading: Boolean = false
) {
    val isEmpty: Boolean get() = filteredProducts.isEmpty()
}

data class CartState(
    val cartItems: CartTableItem = CartTableItem()
)

data class SearchState(
    val isSearching: Boolean = false,
    val query: String = ""
)