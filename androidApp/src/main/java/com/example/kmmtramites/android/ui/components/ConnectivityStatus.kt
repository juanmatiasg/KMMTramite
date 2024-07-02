package com.example.kmmtramites.android.ui.components

import ConnectivityViewModel
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun ConnectivityStatus(connectivityViewModel: ConnectivityViewModel = koinViewModel()) {
    val isConnected by connectivityViewModel.isConnected.collectAsState()

    var showDialog by remember { mutableStateOf(!isConnected) }

    LaunchedEffect(isConnected) {
        showDialog = !isConnected
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text("Sin conexión a Internet") },
            text = { Text("Por favor, verifica tu conexión a Internet.") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Aceptar")
                }
            }
        )
    }
}