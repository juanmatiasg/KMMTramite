package com.example.kmmtramites.android.ui.navigation

sealed class Destinations(val route: String) {
    object Home : Destinations("home")
    object StepOneScreen : Destinations("stepOneScreen/{itemId}") {
        fun createRoute(itemId: String) = "stepOneScreen/$itemId"
    }
}