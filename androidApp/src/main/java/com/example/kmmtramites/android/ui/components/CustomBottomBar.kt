package com.example.kmmtramites.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kmmtramites.android.R

@Composable
fun CustomBottomBar() {
    BottomAppBar(
        containerColor = colorResource(id = R.color.DarkBlue),
        contentColor = colorResource(id = R.color.DarkBlue),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(), contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.ministerio),
                contentDescription = "Ministerio de Justicia",
                modifier = Modifier.padding(10.dp),
                contentScale = ContentScale.Inside
            )
        }

    }
}