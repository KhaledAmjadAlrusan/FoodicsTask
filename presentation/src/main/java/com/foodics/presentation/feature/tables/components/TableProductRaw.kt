package com.foodics.presentation.feature.tables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.foodics.domain.model.local.product.ProductTableItem
import com.foodics.presentation.R
import com.foodics.presentation.component.buttons.CartActionButton
import com.foodics.presentation.shared.theme.AppTypography
import com.foodics.presentation.shared.theme.FoodicsColor

@Composable
fun TableProductRaw(
    modifier: Modifier = Modifier,
    product: ProductTableItem,
    onIncrease: (productId: String) -> Unit,
    onDecrease: (productId: String) -> Unit,
) {
    val productData = product.productRemoteResponse
    Column(
        modifier = modifier
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
            .size(height = 200.dp, width = 180.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = FoodicsColor.white)

    ) {
        AsyncImage(
            model = productData.image,
            contentDescription = productData.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.Crop
        )


        Text(
            modifier = Modifier.padding(8.dp),
            text = productData.name,
            style = AppTypography.displayLarge,
            color = FoodicsColor.textColor,
            minLines = 2,
            maxLines = 2
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = stringResource(R.string.sar) + " ${productData.price}",
                color = FoodicsColor.textColor,
                style = AppTypography.labelLarge,
            )
            CartActionButton(
                onIncrease = {
                    onIncrease(productData.id)
                },
                onDecrease = {
                    onDecrease(productData.id)
                },
                quantity = product.quantity,
            )
        }
    }
}