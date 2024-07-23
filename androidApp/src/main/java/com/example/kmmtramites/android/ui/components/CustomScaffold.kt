package com.example.kmmtramites.android.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kmmtramites.android.R
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

    ConnectivityStatus()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showContent = currentRoute != Destinations.HomeScreen.route

    val title = when (currentRoute) {
        Destinations.HomeScreen.route -> stringResource(id = R.string.stringEmpty)
        Destinations.StepOneScreen.route -> stringResource(id = R.string.listadoDeSociedades)
        Destinations.StepTwoScreen.route -> stringResource(id = R.string.listadoDeTramites)
        Destinations.StepThreeScreen.route -> stringResource(id = R.string.listadoDeVistas)
        Destinations.StepFourScreen.route -> stringResource(id = R.string.vista)
        else -> stringResource(id = R.string.stringEmpty)
    }
    Scaffold(
        topBar = {
            if (showContent) {
                CustomTopAppBar(navController = navController, title = title, date = date, showContent = showContent)
            }
        },

        bottomBar = {
            CustomBottomBar()
        }) { innerPadding ->


        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ) {
            if(showContent) {
                Divider(
                    color = Color.Yellow,
                    thickness = 2.dp
                )
            }
            content()
        }

    }


}