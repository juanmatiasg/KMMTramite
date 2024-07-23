package com.example.kmmtramites.android.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmmtramites.android.R
import com.example.kmmtramites.android.ui.components.CenteredCircularProgressIndicator
import com.example.kmmtramites.android.ui.components.WarningDialog
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


    WarningDialog(showDialog = showDialog, errorMessage = stringResource(id = R.string.warningMessageEntidadNoEncontrada)) {
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
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        item {
            SociedadeseCard(entidad, navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SociedadeseCard(entidad: Entidad, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { navController.navigate(Destinations.StepTwoScreen.createRoute(entidad.correlativo)) }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.razonSocial),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = entidad.razonSocial,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.tipoSocietario),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = entidad.tipoSocietario,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.correlativo),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = entidad.correlativo,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

