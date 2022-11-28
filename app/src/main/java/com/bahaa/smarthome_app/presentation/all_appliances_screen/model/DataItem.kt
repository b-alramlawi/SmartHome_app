package com.bahaa.smarthome_app.presentation.all_appliances_screen.model

import androidx.compose.ui.graphics.painter.Painter


data class DataItem(
    val image: Painter,
    val text: String,
    val textInfo: String,
    val IconCase: Painter

)