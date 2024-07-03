import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmmtramites.android.R
import com.example.kmmtramites.android.ui.navigation.Destinations

@Composable
fun SearchComponent(navController: NavController) {
    var textInput by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf(SearchOption.ByCorrelativeNumber) }
    var showError by remember { mutableStateOf(false) }

    val label = when (selectedOption) {
        SearchOption.ByCorrelativeNumber -> "Nro Correlativo"
        SearchOption.ByTramNumber -> "Nro Tramite"
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { focusManager.clearFocus() }

    ) {
        DisposableEffect(Unit) {
            onDispose {
                keyboardController?.hide()
            }
        }

        val containerColor = colorResource(id = R.color.White)
        OutlinedTextField(
            value = textInput,
            onValueChange = { textInput = it; showError = false },
            label = { Text(label) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
                , imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    if (textInput.isNotBlank()) {
                        navController.navigate(
                            Destinations.StepOneScreen.createRoute(
                                textInput,
                                selectedOption
                            )
                        )
                        keyboardController?.hide()
                    } else {
                        showError = true // Mostrar mensaje de error si el campo está vacío
                    }
                }
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = containerColor,
                unfocusedContainerColor = containerColor,
                disabledContainerColor = containerColor,
                focusedBorderColor = Color.Gray,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = colorResource(id = R.color.Black)
            ),

        )

        if (showError && textInput.isBlank()) {
            Text(
                text = "El campo no puede estar vacío",
                color = Color.Red,
                modifier = Modifier.padding(start = 16.dp, top = 2.dp, bottom = 4.dp)
            )
        }



        Row(
            verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().padding(0.dp)
        ) {
            RadioButton(
                selected = selectedOption == SearchOption.ByCorrelativeNumber,
                onClick = { selectedOption = SearchOption.ByCorrelativeNumber; textInput = "" }
            )

            Text(
                text = "Por Nro correlativo",
                modifier = Modifier.size(100.dp),
                color = colorResource(id = R.color.White),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
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
                modifier = Modifier.size(100.dp),
                color = colorResource(id = R.color.White),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(0.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            Button(
                onClick = {
                    if (textInput.isNotBlank()) {
                        navController.navigate(
                            Destinations.StepOneScreen.createRoute(
                                textInput,
                                selectedOption
                            )
                        )
                    } else {
                        showError = true // Mostrar mensaje de error si el campo está vacío
                    }
                },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.LightBlue))
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


