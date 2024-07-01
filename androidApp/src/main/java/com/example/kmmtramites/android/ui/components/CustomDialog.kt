package com.example.kmmtramites.android.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun CustomDialog() {
    var showSuccessDialog by remember { mutableStateOf(false) }
    var showErrorDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showSuccessDialog = true }) {
            Text("Show Success Dialog")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { showErrorDialog = true }) {
            Text("Show Error Dialog")
        }
    }

    if (showSuccessDialog) {
        SuccessDialog(onDismiss = { showSuccessDialog = false })
    }

    if (showErrorDialog) {
        ErrorDialog(onDismiss = { showErrorDialog = false })
    }
}

@Composable
fun SuccessDialog(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        AnimatedVisibility(
            visible = true,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Success", fontWeight = FontWeight.Bold, color = Color.Green)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("The operation was successful.")
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = onDismiss) {
                        Text("OK")
                    }
                }
            }
        }
    }
}

@Composable
fun ErrorDialog(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        AnimatedVisibility(
            visible = true,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Error", fontWeight = FontWeight.Bold, color = Color.Red)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("There was an error with the operation.")
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = onDismiss) {
                        Text("OK")
                    }
                }
            }
        }
    }
}
