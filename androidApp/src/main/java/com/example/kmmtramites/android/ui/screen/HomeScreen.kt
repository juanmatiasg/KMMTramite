package com.example.kmmtramites.android.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kmmtramites.android.ui.components.CustomHomeScreen
import com.example.kmmtramites.android.ui.navigation.Destinations



@Composable
fun HomeScreen(navController: NavController){
   CustomHomeScreen(onButtonClick = {navController.navigate(Destinations.StepOneScreen.route)})
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview(){
    val navController = rememberNavController()
    CustomHomeScreen(onButtonClick = {navController.navigate(Destinations.StepOneScreen.route)})

}