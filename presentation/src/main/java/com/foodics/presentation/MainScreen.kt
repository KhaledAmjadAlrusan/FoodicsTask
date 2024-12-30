package com.foodics.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.foodics.presentation.shared.navigation.AppNavHost
import com.foodics.presentation.shared.navigation.NavigationBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { NavigationBar(navController) }
    ) { innerPadding ->
        AppNavHost(navController, innerPadding)
    }
}