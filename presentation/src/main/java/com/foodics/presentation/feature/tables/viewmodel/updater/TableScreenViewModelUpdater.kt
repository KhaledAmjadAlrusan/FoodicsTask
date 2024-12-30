package com.foodics.presentation.feature.tables.viewmodel.updater

import com.foodics.domain.model.local.cart.CartTableItem
import com.foodics.domain.model.local.product.ProductTableItem
import com.foodics.domain.model.remote.response.CategoryRemoteResponse
import com.foodics.domain.model.remote.response.ProductRemoteResponse
import com.foodics.presentation.feature.tables.viewmodel.TablesScreenViewModel


fun TablesScreenViewModel.updateCategoryLoading(isLoading: Boolean) {
    updateState {
        copy(
            categoriesState = categoriesState.copy(
                isLoading = isLoading
            )
        )
    }
}

fun TablesScreenViewModel.updateCategories(categories: List<CategoryRemoteResponse>) {
    updateState {
        copy(
            categoriesState = categoriesState.copy(
                categories = categories
            )
        )
    }
}

fun TablesScreenViewModel.updateSelectedCategory(categoryId: String) {
    updateState {
        copy(
            categoriesState = categoriesState.copy(
                selectedCategoryId = categoryId
            )
        )
    }
}

fun TablesScreenViewModel.updateProductsLoading(isLoading: Boolean) {
    updateState {
        copy(
            productsState = productsState.copy(
                isLoading = isLoading
            )
        )
    }
}

fun TablesScreenViewModel.updateFilteredProducts(products: List<ProductTableItem>) {
    updateState {
        copy(
            productsState = productsState.copy(
                filteredProducts = products
            )
        )
    }
}

fun TablesScreenViewModel.updateIsSearching(isSearching: Boolean) {
    updateState {
        copy(
            searchState = searchState.copy(
                isSearching = isSearching
            )
        )
    }
}

fun TablesScreenViewModel.updateAllProducts(products: List<ProductRemoteResponse>) {
    updateState {
        copy(
            productsState = productsState.copy(
                allProducts = products
            )
        )
    }
}

fun TablesScreenViewModel.updateCartItems(cartItems: CartTableItem) {
    updateState {
        copy(
            cartState = cartState.copy(
                cartItems = cartItems
            )
        )
    }
}

fun TablesScreenViewModel.updateError(error: Throwable) {
    updateState {
        copy(
            error = error
        )
    }
}