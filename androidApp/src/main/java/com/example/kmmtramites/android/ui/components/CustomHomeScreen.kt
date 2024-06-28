package com.example.kmmtramites.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kmmtramites.android.R


@Composable
fun CustomHomeScreen(
    onButtonClick: () -> Unit
) {

    var text by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){

            Text("Estado de Trámites y Vistas", fontWeight = FontWeight.Bold, color = Color.White)
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Box(modifier= Modifier
            .fillMaxWidth()
            , contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Ministerio de Just",
                modifier = Modifier
                    .height(225.dp)
                    .width(225.dp),
                contentScale = ContentScale.Crop
            )
        }



        Spacer(modifier = Modifier.padding(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){

            Text("Búsqueda de Sociedades", fontWeight = FontWeight.Bold, color = Color.White)
        }


        Spacer(modifier = Modifier.padding(16.dp))

        SearchComponent(onButtonClick)


    }







}