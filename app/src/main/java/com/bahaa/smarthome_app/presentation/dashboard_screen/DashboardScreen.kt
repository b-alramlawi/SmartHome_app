package com.bahaa.smarthome_app.presentation.dashboard_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bahaa.smarthome_app.R
import com.bahaa.smarthome_app.presentation.ui.theme.Blue600
import com.bahaa.smarthome_app.presentation.ui.theme.Green500
import com.bahaa.smarthome_app.presentation.ui.theme.White

@Composable
fun DashboardScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp),
        ) {
            item {
                WelcomeBox()
                ModeCard()
                RunningAppliances()
                RunningAppliancesSection()
                BillCard()
            }


        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun WelcomeBox(
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Good evening!",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.weight(8f)
            )
            Column {
                Text(
                    text = "06:30", style = MaterialTheme.typography.h2,
                    color = Blue600,
                )
                Text(
                    text = "PM", style = TextStyle(fontSize = 9.sp),
                )
            }
        }
        Text(text = "Ramky Rajendran", style = MaterialTheme.typography.body1)
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun ModeCard(
) {
    Card(
        modifier = Modifier
            .padding(top = 26.dp)
            .width(315.dp)
            .height(216.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(26.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Evening Mode ON", style = MaterialTheme.typography.body1)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "6", style = MaterialTheme.typography.h2)
                    Text(text = "Garden lights", style = TextStyle(fontSize = 12.sp))
                    Text(text = "03:30:33", style = TextStyle(fontSize = 9.sp), color = Green500)

                }
                Column() {
                    Text(text = "4", style = MaterialTheme.typography.h2)
                    Text(text = "cordial light", style = TextStyle(fontSize = 12.sp))
                    Text(text = "03:30:33", style = TextStyle(fontSize = 9.sp), color = Green500)

                }
                Column() {
                    Text(text = "2", style = MaterialTheme.typography.h2)
                    Text(text = "Hall Lights", style = TextStyle(fontSize = 12.sp))
                    Text(text = "02:30:33", style = TextStyle(fontSize = 9.sp), color = Green500)
                }

            }
            Text(
                text = "All lights will switch of automatically as per the timer which is there in the setting.",
                style = TextStyle(fontSize = 10.sp)
            )
        }

    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun RunningAppliances(
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 26.dp)

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Running Appliances",
                style = MaterialTheme.typography.overline,
                modifier = Modifier.weight(8f)
            )
            Text(
                text = "See All", style = MaterialTheme.typography.overline,
                color = Blue600,
            )

        }
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun RunningAppliancesSection(
) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 26.dp),
        horizontalArrangement = Arrangement.SpaceAround,

        ) {
        item {
            RunningAppliancesCard(
                image = painterResource(id = R.drawable.ic_air_conditioner),
                "Air Conditioner", "On for last 3 Hrs"
            )
            Spacer(modifier = Modifier.width(15.dp))
            RunningAppliancesCard(
                image = painterResource(id = R.drawable.ic_light_bulb_on),
                "Smart Light", "On for last 5 Hrs"
            )
            Spacer(modifier = Modifier.width(15.dp))
            RunningAppliancesCard(
                image = painterResource(id = R.drawable.ic_kitchen),
                "Refrigerator", "On for last 2 Days"
            )
        }


    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun RunningAppliancesCard(
    image: Painter,
    text: String,
    textInfo: String
) {

    Card(
        modifier = Modifier
            .width(135.dp)
            .height(153.dp)
            .clip(RoundedCornerShape(16.dp))
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
                painter = image,
                contentDescription = "icon2"
            )
            Text(text = text, style = TextStyle(fontSize = 12.sp))
            Text(text = textInfo, style = TextStyle(fontSize = 9.sp))
            Image(
                painter = painterResource(id = R.drawable.ic_power),
                contentDescription = "icon3"
            )


        }

    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun BillCard(
) {
    Card(
        modifier = Modifier
            .padding(top = 26.dp)
            .width(315.dp)
            .height(186.dp)
            .clip(RoundedCornerShape(16.dp)),
    ) {

        Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.padding(26.dp)) {
            Box() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Box() {
                        Row() {
                            Image(
                                painter = painterResource(id = com.bahaa.smarthome_app.R.drawable.ic_bill),
                                contentDescription = "icon3"
                            )

                            Column() {
                                Text(
                                    text = "January 19 Bill",
                                    style = MaterialTheme.typography.body2
                                )
                                Row(
                                ) {
                                    Text(text = "Due Date", style = TextStyle(fontSize = 11.sp))
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "6 Days",
                                        style = TextStyle(fontSize = 12.sp),
                                        color = Green500
                                    )
                                }


                            }
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(text = "467", style = MaterialTheme.typography.h2)
                        Text(text = "Units", style = TextStyle(fontSize = 10.sp))
                    }


                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Box() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = com.bahaa.smarthome_app.R.drawable.ic_dill),
                            contentDescription = "icon3",
                        )
                        Spacer(modifier = Modifier.width(5.dp))


                        Text(text = "Dill Amount", style = TextStyle(fontSize = 11.sp))


                    }
                }
                Text(text = "₹ 4,654.27", style = TextStyle(fontSize = 11.sp))


            }


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,


                ) {
                Text(text = "View Breakdown", style = TextStyle(fontSize = 12.sp), color = Blue600)
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .width(111.dp)
                        .height(40.dp)
                        .clip(
                            RoundedCornerShape(6.dp)
                        )
                        .background(color = Blue600)
                ) {
                    Text(text = "Pay Bill", style = TextStyle(fontSize = 12.sp), color = White)
                }
            }


        }


    }


}








