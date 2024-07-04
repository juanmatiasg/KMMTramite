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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kmmtramites.android.R
import com.example.kmmtramites.android.ui.components.CenteredCircularProgressIndicator
import com.example.kmmtramites.android.ui.viewmodel.ViewViewModel
import com.example.kmmtramites.domain.model.View
import org.koin.androidx.compose.koinViewModel

@Composable
fun StepThreeScreen(correlativo:String,tramite:String) {

    val viewModel: ViewViewModel = koinViewModel()
    val viewState = viewModel.view.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState().value


    if (isLoading) {
        CenteredCircularProgressIndicator()
    } else {
        ViewsList(viewState.value)
    }


    DisposableEffect(Unit) {
        viewModel.fetchViews(correlativo,tramite)
        onDispose {  }
    }
}

@Composable
fun ViewsList(view: List<View>) {
    LazyColumn {

        items(view) { view ->
            ViewCard(view)
        }
    }
}

@Composable
fun ViewCard(view: View) {
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

            Row {
                Text(
                    text = stringResource(id = R.string.inicioDeTramite),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = view.inicioTramite,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))


            Row {
                Text(
                    text = stringResource(id = R.string.inicioDeVista),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = view.inicioVista,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Text(
                    text = stringResource(id = R.string.inspector),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = view.inspector,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Row {
                Text(
                    text = stringResource(id = R.string.detalleVista),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = view.detalle,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))


        }
    }
}