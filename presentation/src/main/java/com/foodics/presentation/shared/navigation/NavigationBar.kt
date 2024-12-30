package com.foodics.presentation.shared.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.foodics.presentation.shared.theme.FoodicsColor

@Composable
fun NavigationBar(navController: NavHostController) {
    val items = listOf(Screen.Tables, Screen.Orders, Screen.Menu, Screen.Settings)
    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = FoodicsColor.primaryColor,
                    selectedTextColor = FoodicsColor.primaryColor,
                    unselectedIconColor = FoodicsColor.disabledColor,
                    unselectedTextColor = FoodicsColor.disabledColor,
                    indicatorColor = FoodicsColor.transparent
                )
            )
        }
    }
}