package com.example.kmmtramites.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kmmtramites.android.ui.screen.HomeScreen
import com.example.kmmtramites.android.ui.screen.StepOneScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.Home.route) {
        composable(route = Destinations.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Destinations.StepOneScreen.route) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            StepOneScreen(navController, itemId)
        }
    }
}