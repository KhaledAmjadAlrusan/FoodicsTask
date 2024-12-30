package com.foodics.presentation.component.buttons

import androidx.compose.runtime.Composable

@Composable
fun CartActionButton(
    quantity: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
) {
    if (quantity == 0) {
        AddToCartButton(onClick = onIncrease)
    } else {
        QuantityControls(
            quantity = quantity,
            onIncrease = onIncrease,
            onDecrease = onDecrease
        )
    }
}