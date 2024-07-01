package com.example.kmmtramites.android.ui.screen

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmmtramites.android.ui.components.CenteredCircularProgressIndicator
import com.example.kmmtramites.android.ui.navigation.Destinations
import com.example.kmmtramites.android.ui.viewmodel.TramiteViewModel
import com.example.kmmtramites.domain.model.Tramite
import org.koin.androidx.compose.koinViewModel

@Composable
fun StepTwoScreen(navController: NavController, itemId: String?) {

    val viewModel: TramiteViewModel = koinViewModel()
    val photos = viewModel.photos.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState().value


    if (isLoading) {
        CenteredCircularProgressIndicator()
    } else {
        TramiteList(photos.value,navController)
    }


    DisposableEffect(Unit) {
        viewModel.fetchPhotos()
        onDispose {  }
    }
}

@Composable
fun TramiteList(tramite: List<Tramite>, navController: NavController) {
    LazyColumn {
        var unico:List<Tramite> = listOf<Tramite>(
            Tramite("2","Listado de Tramites","","","",true),
            Tramite("3","saracatunga","","","",true)
        )

        items(unico) { tramite ->
            TramiteCard(tramite,navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TramiteCard(tramite: Tramite, navControler: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = {navControler.navigate(Destinations.StepThreeScreen.route)}
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