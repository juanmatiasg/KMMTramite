package com.example.kmmtramites.android.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kmmtramites.android.R

@Composable
fun WarningDialog(showDialog: Boolean, errorMessage: String, onDismiss: () -> Unit) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            containerColor = colorResource(id = R.color.DarkBlue),
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_warning_24), // Reemplaza con tu ícono de error
                    contentDescription = "Icon Warning",
                    modifier = Modifier.size(100.dp),
                    tint = colorResource(id = R.color.YellowDark)

                )
            },
            title = { Text("Advertencia !", color = colorResource(id = R.color.YellowDark)) },
            text = { Text(errorMessage, textAlign = TextAlign.Center, color = colorResource(id = R.color.White)) },
            confirmButton = {
                Button(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.LightBlue))
                ) {
                    Text("OK")
                }
            },
        )


    }
}