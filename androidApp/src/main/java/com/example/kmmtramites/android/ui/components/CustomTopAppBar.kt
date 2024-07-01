package com.example.kmmtramites.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kmmtramites.android.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    date: String,
    navController: NavController,
    showContent: Boolean
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (showContent) {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.width(48.dp)) // Placeholder for back button space
                }

                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )

                if (showContent) {
                    Text(
                        text = date,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                } else {
                    Spacer(modifier = Modifier.width(48.dp)) // Placeholder for date space
                }
            }
        },
        colors = topAppBarColors(
            containerColor = colorResource(id = R.color.DarkBlue)
        )
    )
}
