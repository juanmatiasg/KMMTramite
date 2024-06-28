package com.example.kmmtramites.android.ui.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SearchComponent(onSearchClick: () -> Unit) {
    var text by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf(SearchOption.ByCorrelativeNumber) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter text") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(
                selected = selectedOption == SearchOption.ByCorrelativeNumber,
                onClick = { selectedOption = SearchOption.ByCorrelativeNumber; text = "" }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Por nro correlativo",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = selectedOption == SearchOption.ByTramNumber,
                onClick = { selectedOption = SearchOption.ByTramNumber; text = "" }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Por nro trámite",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    // Aquí puedes realizar la acción según la opción seleccionada
                    if (selectedOption == SearchOption.ByCorrelativeNumber) {
                        text = "Por nro correlativo"
                    } else {
                        text = "Por nro trámite"
                    }
                    onSearchClick()
                }
            ) {
                Text("Buscar", fontWeight = FontWeight.Bold)
            }
        }
    }
}

// Enum para las opciones de búsqueda
enum class SearchOption {
    ByCorrelativeNumber,
    ByTramNumber
}