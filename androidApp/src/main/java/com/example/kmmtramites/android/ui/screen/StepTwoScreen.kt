package com.example.kmmtramites.android.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmmtramites.android.R
import com.example.kmmtramites.android.ui.components.CenteredCircularProgressIndicator
import com.example.kmmtramites.android.ui.components.WarningDialog
import com.example.kmmtramites.android.ui.navigation.Destinations
import com.example.kmmtramites.android.ui.viewmodel.TramiteViewModel
import com.example.kmmtramites.domain.model.Tramite
import org.koin.androidx.compose.koinViewModel
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@Composable
fun StepTwoScreen(navController: NavController, numero: String?) {

    val viewModel: TramiteViewModel = koinViewModel()
    val tramites = viewModel.tramites.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState().value
    val error = viewModel.error.collectAsState()

    // Mostrar el ErrorDialog cuando hay un error
    var showDialog by remember { mutableStateOf(false) }


    WarningDialog(showDialog = showDialog, errorMessage = stringResource(id = R.string.errorMessageNotTramite)) {
        viewModel.clearError()
        navController.popBackStack()  // Volver a la pantalla anterior
    }


    if (isLoading) {
        CenteredCircularProgressIndicator()
    } else {
        if (tramites.value.isEmpty() && error.value!=null) {
            showDialog = true
        } else {
            showDialog = false
            TramiteList(tramites.value,numero!!,navController)

        }
    }
    DisposableEffect(Unit) {
        viewModel.fetchTramites(numero!!)
        onDispose {  }
    }
}

@Composable
fun TramiteList(tramite: List<Tramite>,correlativo: String, navController: NavController) {
    LazyColumn {
        items(tramite) { tramite ->
            TramiteCard(tramite,correlativo,navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TramiteCard(tramite: Tramite,correlativo:String, navController: NavController) {

    val inputFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val outputFormatter = DateTimeFormatter.ofPattern(stringResource(id = R.string.formatDate))


    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { if (tramite.tieneVista) { // Check if tieneVista is true
            navController.navigate(Destinations.StepThreeScreen.createRoute(tramite.numero,correlativo))
        }}
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row {
                Text(
                    text = stringResource(id = R.string.nroTramite),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = tramite.numero,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = stringResource(id = R.string.descripcionTramite),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = tramite.descripcion,
                    style = MaterialTheme.typography.bodyMedium
                )
            }


            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Text(
                    text = stringResource(id = R.string.destinoActualTramite),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = tramite.destinoActual,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Text(
                    text = stringResource(id = R.string.fechaInicioTramite),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = OffsetDateTime.parse(tramite.fechaInicioTramite, inputFormatter).format(outputFormatter)?:"",
                    style = MaterialTheme.typography.bodyMedium
                )
            }


            Spacer(modifier = Modifier.height(4.dp))

            Row{
                Text(
                    text = stringResource(id = R.string.fechaDestinoActualTramite),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = OffsetDateTime.parse(tramite.fechaDestinoActual, inputFormatter).format(outputFormatter)?:"",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Text(
                    text = stringResource(id = R.string.verVistaTramite),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )

                if(tramite.tieneVista) {
                    Text(
                        text = stringResource(id = R.string.vistaDisponible),
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(id = R.color.Green)
                    )
                }
                else {
                    Text(
                        text = stringResource(id = R.string.vistaNoDisponible),
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(id = R.color.Red)
                    )
                }
            }

        }
    }
}