package com.seminario.moviecatalog.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seminario.moviecatalog.ui.screens.catalog.CatalogScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "catalog") {

        composable(
            route = "catalog"
        ) {
            CatalogScreen()
        }

        composable(
            route = "detail/{id}"
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")

        }

    }
}