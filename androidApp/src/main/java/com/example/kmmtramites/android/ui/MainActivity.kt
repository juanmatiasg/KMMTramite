package com.example.kmmtramites.android.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kmmtramites.android.ui.components.CustomScaffold
import com.example.kmmtramites.android.ui.components.CustomTopAppBar
import com.example.kmmtramites.android.ui.navigation.Destinations
import com.example.kmmtramites.android.ui.navigation.NavGraph
import com.example.kmmtramites.android.ui.themes.MyApplicationTheme


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

                    CustomScaffold(navController = navController) {
                        NavGraph(navController = navController)
                    }

                }
            }
        }
    }
}





