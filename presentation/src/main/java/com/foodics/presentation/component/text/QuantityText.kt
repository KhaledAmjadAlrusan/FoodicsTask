package com.foodics.presentation.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.foodics.presentation.shared.theme.FoodicsColor

@Composable
fun QuantityText(
    quantity: Int
) {
    Text(
        text = quantity.toString(),
        color = FoodicsColor.textColor,
        style = MaterialTheme.typography.bodyLarge,
    )
}