package com.foodics.presentation.shared.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodics.presentation.R
import com.foodics.presentation.shared.theme.AppTypography
import com.foodics.presentation.shared.theme.FoodicsColor

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.oh_no),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(
                20.dp
            )
        )

        Text(
            text = stringResource(R.string.oh_no),
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
            text = stringResource(id = R.string.error_occurred),
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