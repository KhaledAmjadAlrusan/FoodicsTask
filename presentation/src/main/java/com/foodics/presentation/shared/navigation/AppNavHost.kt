package com.foodics.presentation.shared.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.foodics.presentation.feature.menu.MenuScreen
import com.foodics.presentation.feature.orders.OrdersScreen
import com.foodics.presentation.feature.settings.SettingsScreen
import com.foodics.presentation.feature.tables.TableScreen


sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Tables : Screen("tables", "Tables", Icons.Filled.Home)
    object Orders : Screen("orders", "Orders", Icons.Filled.ShoppingCart)
    object Menu : Screen("menu", "Menu", Icons.Filled.Menu)
    object Settings : Screen("settings", "Settings", Icons.Filled.Settings)
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Tables.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(Screen.Tables.route) { TableScreen() }
        composable(Screen.Orders.route) { OrdersScreen() }
        composable(Screen.Menu.route) { MenuScreen() }
        composable(Screen.Settings.route) { SettingsScreen() }
    }
}
