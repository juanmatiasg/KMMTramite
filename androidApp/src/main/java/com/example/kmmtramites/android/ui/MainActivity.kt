package com.example.kmmtramites.android.ui

import SplashScreen
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kmmtramites.android.ui.themes.MyApplicationTheme
import com.example.kmmtramites.android.ui.components.CustomScaffold
import com.example.kmmtramites.android.ui.navigation.NavGraph

class MainActivity : ComponentActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    var navigateToHome by remember { mutableStateOf(false) }

                    if (!navigateToHome) {
                        SplashScreen(
                            onDismiss = { navigateToHome = true }
                        )
                    } else {
                        CustomScaffold(navController = navController) {
                            NavGraph(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
