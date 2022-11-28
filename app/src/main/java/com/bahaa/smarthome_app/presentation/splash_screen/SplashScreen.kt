package com.bahaa.smarthome_app.presentation.splash_screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bahaa.smarthome_app.R
import com.bahaa.smarthome_app.presentation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )

        delay(3000L)

        navController.navigate(Screen.DashboardScreen.route) {
            popUpTo(Screen.DashboardScreen.route) { inclusive = true }
        }

    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_splashlogo),
            contentDescription = "Logo",
            contentScale = ContentScale.FillWidth,
        )



        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 20.dp)
        ) {
//            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Happ",
                style = TextStyle(
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily(Font(R.font.sf_compact_display_regular)),
                    fontSize = 27.sp,
                    color = Color.White
                ),
            )

            Text(
                text = "Smart Home",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.sf_compact_display_regular)),
                    fontSize = 14.sp,
                    color = Color.White
                ),
            )

        }
    }
}