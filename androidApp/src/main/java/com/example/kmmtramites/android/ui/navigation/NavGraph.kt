package com.example.kmmtramites.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kmmtramites.android.ui.components.CustomScaffold
import com.example.kmmtramites.android.ui.components.date
import com.example.kmmtramites.android.ui.screen.HomeScreen
import com.example.kmmtramites.android.ui.screen.StepFourScreen
import com.example.kmmtramites.android.ui.screen.StepOneScreen
import com.example.kmmtramites.android.ui.screen.StepThreeScreen
import com.example.kmmtramites.android.ui.screen.StepTwoScreen

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

        composable(route = Destinations.StepTwoScreen.route) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getString("itemId")
                StepTwoScreen(navController, itemId)
        }

        composable(route = Destinations.StepThreeScreen.route) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getString("itemId")
                StepThreeScreen(navController, itemId)
        }

        composable(route = Destinations.StepFourScreen.route) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getString("itemId")
                StepFourScreen(navController, itemId)
        }
    }
}