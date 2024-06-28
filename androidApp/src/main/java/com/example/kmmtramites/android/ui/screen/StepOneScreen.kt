package com.example.kmmtramites.android.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StepOneScreen(navController: NavController, itemId: String?) {
    Text(text = "Detail Screen, itemId: $itemId")
}