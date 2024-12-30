package com.foodics.presentation.feature.tables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.foodics.presentation.R
import com.foodics.presentation.component.buttons.CartCheckoutButton
import com.foodics.presentation.component.search.CustomSearchBar
import com.foodics.presentation.component.tabs.CategoryTabs
import com.foodics.presentation.feature.tables.components.ProductList
import com.foodics.presentation.feature.tables.viewmodel.TablesScreenViewModel
import com.foodics.presentation.feature.tables.viewmodel.state.TablesScreenAction
import com.foodics.presentation.feature.tables.viewmodel.state.TablesScreenState
import com.foodics.presentation.shared.screens.EmptyScreen
import com.foodics.presentation.shared.screens.ErrorScreen
import com.foodics.presentation.shared.screens.LoadingScreen
import com.foodics.presentation.shared.theme.FoodicsColor
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TableScreen(
    viewModel: TablesScreenViewModel = koinViewModel()
) {
    val data by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FoodicsColor.background)
    ) {
        CustomSearchBar(
            placeholder = stringResource(id = R.string.search_for_product),
            onSearch = { viewModel.onInteraction(TablesScreenAction.OnQueryChanged(it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        TableScreenContent(
            modifier = Modifier
                .weight(1f),
            data = data,
            onInteraction = viewModel::onInteraction
        )

        CartCheckoutButton(
            itemCount = data.cartState.cartItems.totalQuantity,
            totalPriceCents = data.cartState.cartItems.totalPrice.toString(),
            buttonText = stringResource(id = R.string.checkout),
            onClick = { viewModel.onInteraction(TablesScreenAction.OnClearCart) }
        )
    }
}

@Composable
fun TableScreenContent(
    modifier: Modifier = Modifier,
    data: TablesScreenState,
    onInteraction: (TablesScreenAction) -> Unit
) {
    Column(
        modifier = modifier
            .background(FoodicsColor.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CategorySection(
            data = data,
            onInteraction = onInteraction
        )

        ProductSection(
            modifier = Modifier.padding(top = 8.dp),
            data = data,
            onInteraction = onInteraction
        )
    }
}


@Composable
fun CategorySection(
    modifier: Modifier = Modifier,
    data: TablesScreenState,
    onInteraction: (TablesScreenAction) -> Unit
) {
    val categoryState = data.categoriesState
    Column(
        modifier = modifier
    ) {
        when {
            categoryState.isLoading -> {
                LoadingScreen()
            }

            data.error != null -> {
                ErrorScreen()
            }

            categoryState.isEmpty -> {
                EmptyScreen(message = stringResource(id = R.string.no_data_found))
            }

            else -> {
                AnimatedVisibility(visible = data.searchState.isSearching.not()) {
                    CategoryTabs(
                        categories = categoryState.categories,
                        selectedCategoryId = categoryState.selectedCategoryId,
                        onCategorySelected = { onInteraction(TablesScreenAction.SelectCategory(it)) }
                    )
                }
            }
        }
    }
}


@Composable
fun ProductSection(
    modifier: Modifier = Modifier,
    data: TablesScreenState,
    onInteraction: (TablesScreenAction) -> Unit
) {
    val productState = data.productsState
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            data.categoriesState.isEmpty -> {
                return
            }

            productState.isLoading -> {
                LoadingScreen()
            }

            productState.isEmpty -> {
                EmptyScreen(message = stringResource(id = R.string.no_data_found))
            }

            else -> {
                ProductList(
                    products = productState.filteredProducts,
                    onInteraction = onInteraction,
                )
            }
        }
    }
}
