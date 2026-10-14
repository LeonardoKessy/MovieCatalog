package com.seminario.moviecatalog.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.seminario.moviecatalog.ui.screens.catalog.CatalogScreen
import com.seminario.moviecatalog.ui.screens.detail.DetailScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "catalog") {

        composable(
            route = "catalog"
        ) {
            CatalogScreen(
                onMovieClick = { movieId ->
                    navController.navigate("detail/$movieId")
                }
            )
        }

        composable(
            route = "detail/{movieId}",
            arguments = listOf(
                navArgument("movieId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("movieId") ?: return@composable

            DetailScreen(
                goBack = { navController.popBackStack() }
            )
        }

    }
}