package com.foodics.presentation.shared.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodics.presentation.R
import com.foodics.presentation.shared.theme.AppTypography
import com.foodics.presentation.shared.theme.FoodicsColor

@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
    message: String
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.no_result),
            contentDescription = null,
            contentScale = ContentScale.Companion.Fit,
            modifier = Modifier.Companion
                .height(200.dp)
                .fillMaxWidth(),

            )

        Spacer(
            modifier = Modifier.Companion.height(
                20.dp
            )
        )
        Text(
            text = "No Data",
            textAlign = TextAlign.Companion.Center,
            modifier = Modifier.Companion
                .padding(top = 20.dp)
                .fillMaxWidth(),
            letterSpacing = 2.sp,
            style = AppTypography.displayLarge,
            color = FoodicsColor.primaryColor,
        )
        Spacer(
            modifier = Modifier.Companion.height(
                8.dp
            )
        )

        Text(
            text = message,
            textAlign = TextAlign.Companion.Center,
            modifier = Modifier.Companion
                .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                .fillMaxWidth(),
            letterSpacing = 1.sp,
            style = AppTypography.displayLarge,
            color = FoodicsColor.primaryColor,
        )
        Spacer(
            modifier = Modifier.Companion.height(
                24.dp
            )
        )
    }
}