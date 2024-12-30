package com.foodics.presentation.feature.tables.viewmodel.state

import com.foodics.domain.enum.QuantityAction

sealed class TablesScreenAction {
    data class SelectCategory(val categoryId: String) : TablesScreenAction()
    data class OnQueryChanged(val query: String) : TablesScreenAction()
    data class OnUpdateProduct(val productId: String, val action: QuantityAction) :
        TablesScreenAction()

    object OnClearCart : TablesScreenAction()
}