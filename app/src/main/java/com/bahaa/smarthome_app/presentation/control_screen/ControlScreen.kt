package com.bahaa.smarthome_app.presentation.control_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bahaa.smarthome_app.R
import com.bahaa.smarthome_app.presentation.ui.theme.Green500

@Composable
fun ControlScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            LivingRoomTopSection()

        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun LivingRoomTopSection(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Living Room",
                style = MaterialTheme.typography.h2,
            )
            Text(text = "Hitachi V9200", style = MaterialTheme.typography.body1)
        }
        Box() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sine_wave),
                    contentDescription = "icon3"
                )
                Spacer(modifier = Modifier.width(10.dp))

                Column() {
                    Text(
                        text = "232",
                        style = MaterialTheme.typography.body2
                    )
                    Row {
                        Text(text = "Volts", style = TextStyle(fontSize = 9.sp))
                    }
                }
            }
        }
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////


@Composable
fun Slider() {


}

