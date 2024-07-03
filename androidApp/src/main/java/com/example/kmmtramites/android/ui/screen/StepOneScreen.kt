package com.example.kmmtramites.android.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmmtramites.android.ui.components.CenteredCircularProgressIndicator
import com.example.kmmtramites.android.ui.components.ErrorDialog
import com.example.kmmtramites.android.ui.navigation.Destinations
import com.example.kmmtramites.android.ui.viewmodel.EntidadViewModel
import com.example.kmmtramites.domain.model.Entidad
import org.koin.androidx.compose.koinViewModel


@Composable
fun StepOneScreen(navController: NavController, numero: String?, searchOption: String) {

    val viewModel: EntidadViewModel = koinViewModel()
    val entidad = viewModel.entidad.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState().value
    val error = viewModel.error.collectAsState()

    // Mostrar el ErrorDialog cuando hay un error
    var showDialog by remember { mutableStateOf(false) }


    ErrorDialog(showDialog = showDialog, errorMessage = "Entidad no encontrada" ?: "") {
        viewModel.clearError()
        navController.popBackStack()  // Volver a la pantalla anterior
    }


    if (isLoading) {
        CenteredCircularProgressIndicator()
    } else {
        if (entidad.value == null && error.value!=null) {
            showDialog = true
        } else {
            showDialog = false
            entidad.value?.let {
                Sociedades(it, navController)
            }


        }
    }


    DisposableEffect(Unit) {

        if (searchOption == "ByCorrelativeNumber") {
            viewModel.fetchEntidadForCorrelativo(numero!!)
        } else {
            viewModel.fetchEntidadForTramite(numero!!)
        }
        onDispose { }
    }
}

@Composable
fun Sociedades(entidad: Entidad, navController: NavController) {
    SociedadeseCard(entidad, navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SociedadeseCard(entidad: Entidad, navControler: NavController) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { navControler.navigate(Destinations.StepTwoScreen.createRoute(entidad.correlativo)) }
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Razón Social: ",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )


                Text(
                    text = entidad.razonSocial ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )
            }


            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Tipo Societario: ",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = entidad.tipoSocietario ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )
            }


            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Correlativo: ",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )


                Text(
                    text = entidad.correlativo ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}

