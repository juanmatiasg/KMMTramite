import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmmtramites.android.R
import kotlinx.coroutines.delay
import kotlin.random.Random


@Composable
fun SplashScreen(
    onDismiss: () -> Unit
) {
    // Animación de escala para la imagen
    val scaleAnimation = rememberInfiniteTransition(label = stringResource(id = R.string.stringEmpty))
    val scale by scaleAnimation.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Restart
        ), label = stringResource(id = R.string.stringEmpty)
    )

    // Simular una espera de 2 segundos antes de navegar
    LaunchedEffect(Unit) {
        delay(2000)
        onDismiss()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center,

    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),  // Reemplaza con tu imagen
            contentDescription = stringResource(id = R.string.logo),
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    alpha = scale // Cambia la opacidad con la escala para efecto suave
                )
        )
    }
}