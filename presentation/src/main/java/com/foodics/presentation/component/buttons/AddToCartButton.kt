package com.foodics.presentation.component.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.foodics.presentation.shared.theme.FoodicsColor

@Composable
fun AddToCartButton(
    onClick: () -> Unit
) {
    CircleButton(
        content = {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                tint = FoodicsColor.iconColor,
                modifier = Modifier.size(24.dp)
            )
        },
        onClick = onClick
    )
}