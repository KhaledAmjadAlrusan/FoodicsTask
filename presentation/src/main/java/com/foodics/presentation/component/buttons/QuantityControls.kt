package com.foodics.presentation.component.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.foodics.presentation.R
import com.foodics.presentation.component.text.QuantityText
import com.foodics.presentation.shared.theme.FoodicsColor

@Composable
fun QuantityControls(
    modifier: Modifier = Modifier,
    quantity: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(FoodicsColor.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        val decreaseIconColors = if (quantity == 1) {
            Pair(
                FoodicsColor.errorContainer,
                FoodicsColor.error
            )
        } else {
            Pair(
                FoodicsColor.background,
                FoodicsColor.textColor,
            )
        }

        IconButton(
            onClick = onDecrease,
            modifier = Modifier
                .clip(CircleShape)
                .background(decreaseIconColors.first)
                .size(32.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = if (quantity == 1) R.drawable.ic_remove_item else R.drawable.ic_minus),
                tint = decreaseIconColors.second,
                contentDescription = "Decrease quantity",
                modifier = Modifier.size(16.dp)
            )
        }

        QuantityText(
            quantity = quantity
        )

        IconButton(
            onClick = onIncrease,
            modifier = Modifier
                .clip(CircleShape)
                .background(FoodicsColor.primaryColor)
                .size(32.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Increase quantity",
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}


@Preview
@Composable
fun QuantityControlsPreview() {
    QuantityControls(
        quantity = 1,
        onIncrease = {},
        onDecrease = {}
    )
}

