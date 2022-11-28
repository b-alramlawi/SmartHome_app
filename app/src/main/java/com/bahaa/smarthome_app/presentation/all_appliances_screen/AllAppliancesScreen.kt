package com.bahaa.smarthome_app.presentation.all_appliances_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bahaa.smarthome_app.R
import com.bahaa.smarthome_app.presentation.all_appliances_screen.model.DataItem

@Composable
fun AllAppliancesScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            AllDevicesTopSection()
            RoomCardSecondSection()
            DevicesGridView()

        }
    }
}

//    }
//}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun AllDevicesTopSection(
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
                text = "All Devices",
                style = MaterialTheme.typography.h2,
            )
            Text(text = "Devices which linked with Happ", style = MaterialTheme.typography.body1)
        }
        Box(
        ) {
            Card(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "icon2",
                    modifier = Modifier.padding(15.dp)
                )
            }
        }
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////

//==================================================================================================

@Composable
fun RoomCardSecondSection(
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 26.dp),

        horizontalArrangement = Arrangement.SpaceAround

    ) {
        item {
            RoomCard(
                title = "Bed Room",
            )
            Spacer(modifier = Modifier.width(15.dp))
            RoomCard(
                title = "Kitchen",
            )
            Spacer(modifier = Modifier.width(15.dp))
            RoomCard(
                title = " ",
            )
        }


    }
}

//==================================================================================================
@Composable
fun RoomCard(
    title: String,
) {
    Card(
        modifier = Modifier
            .width(136.dp)
            .height(58.13.dp)
            .clip(RoundedCornerShape(16.dp)),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
            )
        }
    }

}
//==================================================================================================

////////////////////////////////////////////////////////////////////////////////////////////////////


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DevicesGridView() {
    DevicesSection(item = listOf(
        DataItem(
            painterResource(id = R.drawable.ic_air_conditioner),
            "Air Conditioner",
            "On for last 3 Hrs",
            painterResource(id = R.drawable.ic_power)
        ),
        DataItem(
            painterResource(id = R.drawable.ic_light_bulb_on),
            "Smart Light",
            "On for last 5 Hrs",
            painterResource(id = R.drawable.ic_power)
        ),
        DataItem(
            painterResource(id = R.drawable.ic_fan),
            "Fan",
            "Off from last 23 Hrs",
            painterResource(id = R.drawable.ic_power_gray)
        ),
    ).map { it })
}

//==================================================================================================

////////////////////////////////////////////////////////////////////////////////////////////////////

@ExperimentalFoundationApi
@Composable
fun DevicesSection(
    item: List<DataItem>,
) {
    LazyVerticalGrid(modifier = Modifier.padding(top = 26.dp),
        cells = GridCells.Fixed(2),
    ) {
        items(item.size) {
            Card(
                modifier = Modifier
                    .padding(end = 20.dp, bottom = 20.dp)
                    .width(135.dp)
                    .height(153.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .height(80.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_ellipse),
                        contentDescription = "icon1",
                        modifier = Modifier.align(Alignment.End)
                    )
                    Image(
                        painter = item[it].image,
                        contentDescription = "icon2"
                    )
                    Text(text = item[it].text, style = TextStyle(fontSize = 12.sp))
                    Text(text = item[it].textInfo, style = TextStyle(fontSize = 9.sp))
                    Image(
                        painter = item[it].IconCase,
                        contentDescription = "icon3"
                    )


                }

            }
        }
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////


//==================================================================================================


////////////////////////////////////////////////////////////////////////////////////////////////////









