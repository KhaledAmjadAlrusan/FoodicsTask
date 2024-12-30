package com.foodics.presentation.component.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.foodics.presentation.shared.theme.FoodicsColor

@Composable
fun CartCheckoutButton(
    itemCount: Int,
    totalPriceCents: String,
    buttonText: String,
    onClick: () -> Unit,
    isLoading: Boolean = false,
    modifier: Modifier = Modifier
) {
    if (itemCount == 0) return
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(56.dp)
            .clickable(enabled = !isLoading) { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isLoading) FoodicsColor.disabledColor else FoodicsColor.primaryColor,
            contentColor = FoodicsColor.white
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val textColor = if (isLoading)
                FoodicsColor.white
            else
                FoodicsColor.white


            val textBackground = if (isLoading)
                FoodicsColor.disabledColor
            else
                FoodicsColor.white

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = modifier
                        .size(24.dp)
                        .background(textBackground, CircleShape),
                    contentAlignment = Alignment.Center
                ) {

                    val numberColor = if (isLoading)
                        FoodicsColor.white
                    else
                        FoodicsColor.primaryColor
                    Text(
                        text = itemCount.toString(),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.ExtraBold
                        ),
                        color = numberColor,
                    )
                }

                Spacer(modifier = modifier.width(8.dp))



                Text(
                    text = totalPriceCents,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = textColor,
                )

                Spacer(modifier = modifier.width(16.dp))

                if (isLoading) {

                    CircularProgressIndicator(
                        modifier = modifier.size(24.dp),
                        color = textColor
                    )
                }

            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = buttonText,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = textColor,
                    modifier = modifier
                )


                Spacer(modifier = modifier.width(4.dp))


                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "",
                    tint = FoodicsColor.white,

                    )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CustomCartDisabledButtonPreview() {
    CartCheckoutButton(
        itemCount = 3,
        totalPriceCents = "SAR 120",
        buttonText = "Checkout",
        onClick = {},
        isLoading = false
    )
}

@Composable
@Preview(showBackground = true)
fun CustomCartEnabledButtonPreview() {
    CartCheckoutButton(
        itemCount = 3,
        totalPriceCents = "SAR 120",
        buttonText = "Checkout",
        onClick = {},
        isLoading = true
    )
}
