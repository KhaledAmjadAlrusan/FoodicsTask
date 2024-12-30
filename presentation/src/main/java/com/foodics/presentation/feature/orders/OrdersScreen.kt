package com.foodics.presentation.feature.orders

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.foodics.presentation.R
import com.foodics.presentation.shared.screens.EmptyScreen

@Composable
fun OrdersScreen() {
    EmptyScreen(
        message = stringResource(id = R.string.empty_screen)
    )
}