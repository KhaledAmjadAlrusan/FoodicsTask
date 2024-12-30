package com.foodics.presentation.feature.tables.viewmodel

import com.foodics.core.base.BaseViewModel
import com.foodics.domain.enum.QuantityAction
import com.foodics.domain.mapper.toCartTableItem
import com.foodics.domain.mapper.toProductTableItem
import com.foodics.domain.model.local.cart.CartTableItem
import com.foodics.domain.model.local.product.ProductTableItem
import com.foodics.domain.model.remote.response.ProductRemoteResponse
import com.foodics.domain.usecase.cart.ClearCartUseCase
import com.foodics.domain.usecase.cart.GetCartItemsUseCase
import com.foodics.domain.usecase.cart.UpdateItemQuantityUseCase
import com.foodics.domain.usecase.category.FetchCategoriesUseCase
import com.foodics.domain.usecase.product.FetchProductsByCategoryIdUseCase
import com.foodics.domain.usecase.product.FetchProductsUseCase
import com.foodics.presentation.feature.tables.viewmodel.state.*
import com.foodics.presentation.feature.tables.viewmodel.updater.*

class TablesScreenViewModel(
    private val fetchProductsByCategoryIdUseCase: FetchProductsByCategoryIdUseCase,
    private val fetchCategoriesUseCase: FetchCategoriesUseCase,
    private val fetchProductsUseCase: FetchProductsUseCase,
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val updateItemQuantityUseCase: UpdateItemQuantityUseCase,
    private val clearCartUseCase: ClearCartUseCase,
) : BaseViewModel<TablesScreenState>(TablesScreenState()) {

    init {
        initializeScreen()
    }

    private fun initializeScreen() {
        loadCartItems()
        fetchCategories()
        fetchProductsForSelectedCategory()
    }

    fun onInteraction(action: TablesScreenAction) {
        when (action) {
            is TablesScreenAction.SelectCategory -> fetchProducts(action.categoryId)

            is TablesScreenAction.OnUpdateProduct -> updateProductQuantity(
                action.productId,
                action.action
            )

            is TablesScreenAction.OnQueryChanged -> handleSearch(action.query)

            is TablesScreenAction.OnClearCart -> clearCart()
        }
    }

    private fun fetchCategories() {
        execute(
            loadingSetter = { isLoading ->
                updateCategoryLoading(isLoading)
            },
            block = { fetchCategoriesUseCase() },
            onSuccess = { categories ->
                updateCategories(categories)
                categories.firstOrNull()?.id?.let {
                    updateSelectedCategory(it)
                    fetchProducts(it)
                }
            },
            onError = {
                updateError(it)
            }
        )
    }

    private fun fetchProducts(categoryId: String) {
        execute(
            loadingSetter = { isLoading ->
                updateProductsLoading(isLoading)
            },
            block = {
                fetchProductsByCategoryIdUseCase(categoryId).map {
                    it.toProductTableItem(
                        quantity = getProductQuantity(it.id)
                    )
                }
            },
            onSuccess = { products ->
                updateSelectedCategory(categoryId)
                updateFilteredProducts(products)
            },
            onError = {
                updateError(it)
            }
        )
    }

    private fun fetchProductsForSelectedCategory() {
        getSelectedCategoryId()?.let {
            fetchProducts(it)
        }
    }

    private fun loadCartItems() {
        execute(
            block = { getCartItemsUseCase().toCartTableItem() },
            onSuccess = { cartItems ->
                updateCartItems(cartItems)
                refreshProductQuantities(cartItems)
            },
            onError = { updateError(it) }
        )
    }

    private fun updateProductQuantity(productId: String, action: QuantityAction) {
        execute(
            block = { updateItemQuantityUseCase(productId, action) },
            onSuccess = { loadCartItems() },
            onError = { updateError(it) }
        )
    }

    private fun clearCart() {
        execute(
            block = { clearCartUseCase() },
            onSuccess = { loadCartItems() },
            onError = { updateError(it) }
        )
    }

    private fun handleSearch(query: String) {
        updateIsSearching(query.isNotBlank())

        if (query.isBlank()) {
            fetchProductsForSelectedCategory()
        } else {
            execute(
                block = {
                    if (getAllProduct().isEmpty()) fetchProductsUseCase()
                    else getAllProduct()
                },
                onSuccess = { allProducts ->
                    val filteredProducts = filterProductsByQuery(
                        products = allProducts,
                        query = query
                    )

                    updateFilteredProducts(filteredProducts)
                    updateAllProducts(allProducts)
                },
                onError = {
                    updateError(it)
                }
            )
        }
    }

    private fun filterProductsByQuery(
        products: List<ProductRemoteResponse>,
        query: String
    ): List<ProductTableItem> {
        return products.filter {
            it.name.contains(query, ignoreCase = true)
        }.map {
            it.toProductTableItem(getProductQuantity(it.id))
        }
    }

    private fun getProductQuantity(productId: String, cartItems: CartTableItem): Int {
        return cartItems.productQuantity.firstOrNull { it.first == productId }?.second ?: 0
    }

    private fun refreshProductQuantities(cartItems: CartTableItem) {
        val updatedProducts = getFilteredProducts().map { product ->
            product.copy(quantity = getProductQuantity(product.productRemoteResponse.id, cartItems))
        }

        updateFilteredProducts(updatedProducts)
    }
}