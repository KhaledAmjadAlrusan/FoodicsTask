package com.foodics.presentation.feature.tables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.foodics.domain.enum.QuantityAction
import com.foodics.domain.model.local.product.ProductTableItem
import com.foodics.presentation.feature.tables.viewmodel.state.TablesScreenAction
import com.foodics.presentation.shared.theme.FoodicsColor
import kotlin.collections.forEach

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductList(
    products: List<ProductTableItem>,
    onInteraction: (TablesScreenAction) -> Unit
) {
    FlowRow(
        modifier = Modifier
            .background(FoodicsColor.background)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        products.forEach { product ->
            TableProductRaw(
                product = product,
                onIncrease = {
                    onInteraction(
                        TablesScreenAction.OnUpdateProduct(
                            it,
                            QuantityAction.Increase
                        )
                    )
                },
                onDecrease = {
                    onInteraction(
                        TablesScreenAction.OnUpdateProduct(
                            it,
                            QuantityAction.Decrease
                        )
                    )
                }
            )
        }
    }
}