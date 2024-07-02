package com.example.kmmtramites.android.ui.screen

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmmtramites.android.ui.components.CenteredCircularProgressIndicator
import com.example.kmmtramites.android.ui.viewmodel.TramiteViewModel
import com.example.kmmtramites.domain.model.Tramite
import org.koin.androidx.compose.koinViewModel

@Composable
fun StepFourScreen(navController: NavController, itemId: String?) {

    val viewModel: TramiteViewModel = koinViewModel()
    val photos = viewModel.tramites.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState().value


    if (isLoading) {
        CenteredCircularProgressIndicator()
    } else {
        val tramite = Tramite("1","Vista","","","",false)
        VieweCardFinal(tramite)
    }

    DisposableEffect(Unit) {
        //viewModel.fetchTramites()
        onDispose {  }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VieweCardFinal(tramite: Tramite) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = tramite.numero?:"",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = tramite.descripcion?:"",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = tramite.destinoActual.toString()?:"",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = tramite.fechaInicioTramite.toString()?:"",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = tramite.fechaDestinoActual.toString()?:"",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = tramite.tieneVista.toString()?:"",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}