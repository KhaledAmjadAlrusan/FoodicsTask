package com.foodics.presentation.shared.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.foodics.presentation.R

val AppFontFamily = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    labelMedium = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
)
