package com.foodics.presentation.component.tabs

import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodics.domain.model.remote.response.CategoryRemoteResponse
import com.foodics.presentation.shared.theme.FoodicsColor

@Composable
fun CategoryTabs(
    categories: List<CategoryRemoteResponse>,
    selectedCategoryId: String?,
    onCategorySelected: (String) -> Unit
) {
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(
            categories.indexOfFirst { it.id == selectedCategoryId }.takeIf { it != -1 } ?: 0
        )
    }

    val unselectedTextStyle =
        TextStyle(
            color = FoodicsColor.disabledColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500
        )
    val selectedTextStyle =
        TextStyle(color = FoodicsColor.primaryColor, fontSize = 16.sp, fontWeight = FontWeight.W700)

    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        containerColor = FoodicsColor.background,
        contentColor = FoodicsColor.primaryColor,
        edgePadding = 16.dp
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                text = {
                    Text(
                        text = category.name,
                        style = if (index == selectedIndex) selectedTextStyle else unselectedTextStyle
                    )
                },
                selected = index == selectedIndex,
                onClick = {
                    if (selectedIndex != index) {
                        selectedIndex = index
                        onCategorySelected(category.id)
                    }
                },
                selectedContentColor = FoodicsColor.primaryColor,
                unselectedContentColor = FoodicsColor.background
            )
        }
    }
}