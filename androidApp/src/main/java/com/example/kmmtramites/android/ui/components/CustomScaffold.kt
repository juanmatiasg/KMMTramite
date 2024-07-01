package com.example.kmmtramites.android.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kmmtramites.android.ui.navigation.Destinations
import com.example.kmmtramites.android.ui.navigation.NavGraph
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("ConstantLocale")
var date: String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CustomScaffold(navController: NavController, content: @Composable () -> Unit) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showContent = currentRoute != Destinations.Home.route

     val title = when (currentRoute) {
        Destinations.Home.route -> ""
        Destinations.StepOneScreen.route -> "Listado de Sociedades"
        Destinations.StepTwoScreen.route -> "Listado de Trámites"
        Destinations.StepThreeScreen.route -> "Listado de Vistas"
        Destinations.StepFourScreen.route -> "Vista"
        else -> ""
    }
    Scaffold(
        topBar = {
            CustomTopAppBar(navController = navController,title = title, date = date, showContent = showContent)
        },

        bottomBar = {
            CustomBottomBar()
        }) { innerPadding ->


        Column(modifier = Modifier.padding(innerPadding)) {
            if(showContent) {
                Divider(
                    color = Color.Yellow,
                    thickness = 2.dp
                ) // Divider con color amarillo y grosor de 2dp
            }
            content()
        }

    }
}