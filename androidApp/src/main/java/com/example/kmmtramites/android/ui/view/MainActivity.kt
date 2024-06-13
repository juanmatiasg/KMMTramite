package com.example.kmmtramites.android.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.kmmtramites.android.ui.viewmodel.PhotoViewModel
import com.example.kmmtramites.domain.model.Photo
import org.koin.androidx.compose.koinViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    PhotosScreen()
                }
            }
        }
    }
}


@Composable
fun PhotosScreen(viewModel: PhotoViewModel = koinViewModel()) {
    val photos  =  viewModel.photos.collectAsState()
    val error = viewModel.error.collectAsState()
    val isLoading  = viewModel.isLoading.collectAsState().value

    when {
        isLoading -> {
            CenteredCircularProgressIndicator()
        }
        error != null -> {
            Text("Error: $error")
        }
        else -> {
            // Mostrar la lista de fotos
            PhotoList(photos.value)

        }
    }

    LaunchedEffect(Unit){
        viewModel.fetchPhotos()
    }
}

@Composable
fun PhotoList(photos: List<Photo>) {
    LazyColumn {
        items(photos) { photo ->
            PhotoCard(photo)
        }
    }
}

@Composable
fun PhotoCard(photo: Photo) {
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
            Image(
                painter = rememberAsyncImagePainter(model = photo.url),
                contentDescription = photo.title,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = photo.title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = photo.albumId.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun CenteredCircularProgressIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp), // Adjust size as needed
            color = Color.Blue // Adjust color as needed
        )
    }
}

