package com.example.kmmtramites.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kmmtramites.android.ui.navigation.NavGraph
import com.example.kmmtramites.android.ui.themes.MyApplicationTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }
}


/*@Composable
fun PhotosScreen(viewModel: TramiteViewModel = koinViewModel()) {
    val photos = viewModel.photos.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState().value


    if (isLoading) {
        CenteredCircularProgressIndicator()
    } else {
        PhotoList(photos.value)
    }


    DisposableEffect(Unit) {
        viewModel.fetchPhotos()
        onDispose {  }
    }
}
@Composable
fun PhotoList(photos: List<Tramite>) {
    LazyColumn {
        items(photos) { photo ->
            PhotoCard(photo)
        }
    }
}

@Composable
fun PhotoCard(photo: Tramite) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = photo.numero?:"",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = photo.descripcion?:"",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = photo.destinoActual.toString()?:"",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = photo.fechaInicioTramite.toString()?:"",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = photo.fechaDestinoActual.toString()?:"",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = photo.tieneVista.toString()?:"",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}*/

