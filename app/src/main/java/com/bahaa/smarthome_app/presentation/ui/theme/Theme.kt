package com.bahaa.smarthome_app.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Blue600,
    primaryVariant = White,
    secondary = Black,
    onPrimary = White,
    onSecondary = White,
    background = Black,
    onBackground = White,
    surface = Black,
    onSurface = White

)

private val LightColorPalette = lightColors(
    primary = Blue600,
    primaryVariant = Purple700,
    secondary = Teal200,
    onPrimary = Black,
    onSecondary = Black,
    background = White50,
    onBackground = Black,
    surface = White,
    onSurface = Black


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun SmartHome_appTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}