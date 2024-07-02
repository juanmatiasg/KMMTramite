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
import com.example.kmmtramites.domain.model.View
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.HomeScreen.route) {
        composable(route = Destinations.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(route = Destinations.StepOneScreen.route) { backStackEntry ->
            val numero = backStackEntry.arguments?.getString("numero")
            val searchOption = backStackEntry.arguments?.getString("searchOption")
            StepOneScreen(navController, numero,searchOption!!)
        }

        composable(route = Destinations.StepTwoScreen.route) { backStackEntry ->
            val numero = backStackEntry.arguments?.getString("numero")
            StepTwoScreen(navController, numero)
        }

        composable(route = Destinations.StepThreeScreen.route) { backStackEntry ->
            val correlativo = backStackEntry.arguments?.getString("correlativo")
            val tramite = backStackEntry.arguments?.getString("tramite")

            StepThreeScreen(correlativo = correlativo!!, tramite = tramite!!)
        }

        composable(route = Destinations.StepFourScreen.route) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            StepFourScreen(navController, itemId)
        }
    }
}