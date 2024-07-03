package com.example.kmmtramites.android.ui.navigation
import SearchOption

sealed class Destinations(val route: String) {
    //Home Input
    object HomeScreen : Destinations("homeScreen"){}

    //Listado de Sociedades
    object StepOneScreen : Destinations("stepOneScreen/{numero}/{searchOption}") {
        fun createRoute(numero: String, searchOption: SearchOption) = "stepOneScreen/$numero/${searchOption}"
    }

    //Listado de Tramites
    object StepTwoScreen : Destinations("stepTwoScreen/{numero}") {
        fun createRoute(numero: String) = "stepTwoScreen/$numero"
    }

    //Listado de Vista
    object StepThreeScreen : Destinations("stepThreeScreen/{tramite}/{correlativo}") {
        fun createRoute(tramite: String, correlativo: String) = "stepThreeScreen/$tramite/$correlativo"
    }

    //Vista
    object StepFourScreen : Destinations("stepFourScreen/{itemId}") {
        fun createRoute(itemId: String) = "stepFourScreen/$itemId"
    }
}