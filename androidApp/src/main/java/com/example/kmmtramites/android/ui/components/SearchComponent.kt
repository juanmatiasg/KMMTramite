package com.example.kmmtramites.android.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmmtramites.android.R
import com.example.kmmtramites.android.ui.navigation.Destinations

@Composable
fun SearchComponent(navController: NavController) {

    var textInput by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf(SearchOption.ByCorrelativeNumber) }

    val label = when (selectedOption) {
        SearchOption.ByCorrelativeNumber -> "Nro Correlativo"
        SearchOption.ByTramNumber -> "Nro Tramite"
    }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { focusManager.clearFocus() }
    ) {
        val containerColor = colorResource(id = R.color.White)
        OutlinedTextField(
            value = textInput,
            onValueChange = { textInput = it },
            label = { Text(label) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),

            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = containerColor,
                unfocusedContainerColor = containerColor,
                disabledContainerColor = containerColor,
                focusedBorderColor = Color.Gray,
                focusedLabelColor = Color.Gray
                , unfocusedLabelColor = colorResource(id = R.color.Black)
            ),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()

        ) {
            RadioButton(
                selected = selectedOption == SearchOption.ByCorrelativeNumber,
                onClick = { selectedOption = SearchOption.ByCorrelativeNumber; textInput = "" }
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Por Nro correlativo",
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.White)
                , textAlign = TextAlign.Center
            )


            RadioButton(
                selected = selectedOption == SearchOption.ByTramNumber,
                onClick = { selectedOption = SearchOption.ByTramNumber; textInput = "" },
                colors = RadioButtonDefaults.colors(
                    selectedColor = colorResource(id = R.color.White),
                    unselectedColor = colorResource(id = R.color.White)
                )
            )

            Text(
                text = "Por Nro trámite",
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.White),
                textAlign = TextAlign.Center
            )
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navController.navigate(Destinations.StepOneScreen.createRoute(textInput,selectedOption))
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

