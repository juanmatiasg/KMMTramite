package com.example.kmmtramites.android.ui.navigation

sealed class Destinations(val route: String) {
    object Home : Destinations("home")

    object StepOneScreen : Destinations("stepOneScreen/{itemId}") {
        fun createRoute(itemId: String) = "stepOneScreen/$itemId"
    }

    object StepTwoScreen : Destinations("stepTwoScreen/{itemId}") {
        fun createRoute(itemId: String) = "stepTwoScreen/$itemId"
    }

    object StepThreeScreen : Destinations("stepThreeScreen/{itemId}") {
        fun createRoute(itemId: String) = "stepThreeScreen/$itemId"
    }

    object StepFourScreen : Destinations("stepFourScreen/{itemId}") {
        fun createRoute(itemId: String) = "stepFourScreen/$itemId"
    }
}