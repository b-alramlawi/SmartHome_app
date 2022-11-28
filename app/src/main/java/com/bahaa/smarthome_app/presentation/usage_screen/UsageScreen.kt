package com.bahaa.smarthome_app.presentation.usage_screen


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bahaa.smarthome_app.R
import com.bahaa.smarthome_app.presentation.ui.theme.*

@Composable
fun UsageScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp),
        ) {
            item {
                FirstSection()
                ProgressBarSection()
                ModeCard()
                AllAppliances()
                AppliancesSection()
            }


        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun FirstSection(
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
                text = "Electricity Usage",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.weight(8f)
            )
        }
        Text(text = "Of your Farm House", style = MaterialTheme.typography.body1)
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun ProgressBarSection(
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 26.dp),
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        CircularProgressBarCard(
            "Today Consumption",
            dataUsage = 26f,
            dataTotal = 100,
            Blue300
        )
        CircularProgressBarCard(
            "Overall Consumption",
            dataUsage = 467f,
            dataTotal = 650,
            Blue600
        )


    }
}

@Composable
fun CircularProgressBarCard(
    title: String,
    dataUsage: Float,
    dataTotal: Int,
    foregroundIndicatorColor: Color
) {

    Card(
        modifier = Modifier
            .width(147.dp)
            .height(179.8.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly

        ) {
            Text(text = title, style = TextStyle(fontSize = 12.sp))
            CircularProgressbar(
                dataUsage = dataUsage,
                foregroundIndicatorColor = foregroundIndicatorColor,
                dataTotal = dataTotal
            )
        }


    }
}


//==================================================================================================

@Composable
fun CircularProgressbar(
    foregroundIndicatorColor: Color,
    dataUsage: Float,
    dataTotal: Int,
    size: Dp = 87.08.dp,
    shadowColor: Color = Gray300,
    indicatorThickness: Dp = 7.dp,
    animationDuration: Int = 1000,
    dataTextStyle: TextStyle = TextStyle(
        fontSize = MaterialTheme.typography.h3.fontSize
    ),

    ) {

    // It remembers the data usage value
    var dataUsageRemember by remember {
        mutableStateOf(-1f)
    }

    // This is to animate the foreground indicator
    val dataUsageAnimate = animateFloatAsState(
        targetValue = dataUsageRemember,
        animationSpec = tween(
            durationMillis = animationDuration
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        dataUsageRemember = dataUsage
    }

    Box(
        modifier = Modifier
            .size(size),
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier
                .size(size)
        ) {

            // For shadow
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(shadowColor, Gray300),
                    center = Offset(x = this.size.width / 2, y = this.size.height / 2),
                    radius = this.size.height / 2
                ),
                radius = this.size.height / 2,
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            // This is the white circle that appears on the top of the shadow circle
            drawCircle(
                color = Color.White,
                radius = (size / 2 - indicatorThickness).toPx(),
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            // Convert the dataUsage to angle
            val sweepAngle = (dataUsageAnimate.value) * 360 / dataTotal

            // Foreground indicator
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round),
                size = Size(
                    width = (size - indicatorThickness).toPx(),
                    height = (size - indicatorThickness).toPx()
                ),
                topLeft = Offset(
                    x = (indicatorThickness / 2).toPx(),
                    y = (indicatorThickness / 2).toPx()
                )
            )
        }

        // Display the data usage value
        DisplayText(
            animateNumber = dataUsageAnimate,
            dataTextStyle = dataTextStyle,
        )
    }

}


@Composable
private fun DisplayText(
    animateNumber: State<Float>,
    dataTextStyle: TextStyle,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Text that shows the number inside the circle
        Text(
            text = (animateNumber.value).toInt().toString(),
            style = dataTextStyle
        )
        Text(
            text = "Units",
            style = TextStyle(fontSize = 12.sp)
        )
    }
}


//==================================================================================================


////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun ModeCard(
) {
    Card(
        modifier = Modifier
            .padding(top = 26.dp)
            .width(335.dp)
            .height(281.09.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column() {
            UsageMeterTop()
            AllUsageMeterProgress()
            DevicesStats()
        }

    }
}


//==================================================================================================
@Composable
fun UsageMeterTop(
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(26.dp),

        ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Usage Meter",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.weight(8f)
            )
            Box(
                modifier = Modifier
                    .width(76.dp)
                    .height(33.dp)
                    .border(width = 1.dp, color = Gray300, shape = RoundedCornerShape(15.dp))
                    .align(
                        Alignment.CenterVertically
                    ),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Today")
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_drop_down),
                        contentDescription = "ArrowDropDown"
                    )
                }
            }


        }
    }
}
//==================================================================================================


@Composable
fun AllUsageMeterProgress(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 26.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        VerticalProgress(
            progress = 0.2f,
            indicatorBackground = Blue100,
            indicatorHeight = 39.28.dp,
            circleBackground = Blue100
        )
        VerticalProgress(
            progress = 0.2f,
            indicatorBackground = Blue300,
            indicatorHeight = 53.dp,
            circleBackground = Blue300
        )
        VerticalProgress(
            progress = 0.2f,
            indicatorBackground = Green200,
            indicatorHeight = 43.dp,
            circleBackground = Green200
        )
        VerticalProgress(
            progress = 0.2f,
            indicatorBackground = Blue1600,
            indicatorHeight = 69.dp,
            circleBackground = Blue1600
        )
        VerticalProgress(
            progress = 0.2f,
            indicatorBackground = Green400,
            indicatorHeight = 55.74.dp,
            circleBackground = Green400
        )
        VerticalProgress(
            progress = 0.2f,
            indicatorBackground = Olive700,
            indicatorHeight = 37.8.dp,
            circleBackground = Olive700
        )
    }
}


@Composable
fun VerticalProgress(
    progress: Float,
    indicatorBackground: Color,
    indicatorHeight: Dp,
    circleBackground: Color,
    modifier: Modifier = Modifier,

    ) {
    val mProgress = animateFloatAsState(targetValue = progress / 100)
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(color = indicatorBackground.copy(alpha = .4f))
            .width(8.74.dp)
            .height(indicatorHeight)
    ) {
        Box(
            modifier = Modifier
                .weight((if ((1 - mProgress.value) == 0f) 0.0001 else 1 - mProgress.value) as Float)
                .fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .width(9.dp)
                .height(8.74.dp)
                .background(
                    color = circleBackground
                )
        )
    }
}


//==================================================================================================

@Composable
fun DevicesStats(

) {
    Box(
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(26.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {
                Column() {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .width(6.dp)
                                .height(6.dp)
                                .background(
                                    color = Blue100
                                )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Air Conditioner", style = TextStyle(fontSize = 11.sp))
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .width(6.dp)
                                .height(6.dp)
                                .background(
                                    color = Blue300
                                )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Water Heater", style = TextStyle(fontSize = 11.sp))
                    }
                }
                Column() {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .width(6.dp)
                                .height(6.dp)
                                .background(
                                    color = Green200
                                )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Refridgelator", style = TextStyle(fontSize = 11.sp))
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .width(6.dp)
                                .height(6.dp)
                                .background(
                                    color = Blue1600
                                )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Fans", style = TextStyle(fontSize = 11.sp))
                    }
                }
                Column() {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .width(6.dp)
                                .height(6.dp)
                                .background(
                                    color = Green400
                                )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Lights", style = TextStyle(fontSize = 11.sp))
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .width(6.dp)
                                .height(6.dp)
                                .background(
                                    color = Olive700
                                )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Others", style = TextStyle(fontSize = 11.sp))
                    }
                }

            }
            Text(
                text = "Spending more on air conditioner save more by switching ac to the room temperature at night time.",
                style = TextStyle(fontSize = 9.sp)
            )
        }

    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////


@Composable
fun AllAppliances(
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
                text = "All Appliances",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.weight(8f)
            )

        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun AppliancesSection(
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 26.dp),
        horizontalArrangement = Arrangement.SpaceAround

    ) {
        item {
            AppliancesCardWithText(
                image = painterResource(id = R.drawable.ic_air_conditioner),
                icon = painterResource(id = R.drawable.ic_ellipse),
                title = "Air Conditioner",
                textInfo = "26 Units"
            )
            Spacer(modifier = Modifier.width(15.dp))
            AppliancesCardWithText(
                image = painterResource(id = R.drawable.ic_washing_machine),
                icon = painterResource(id = R.drawable.ic_ellipse_undefined),
                title = "Washing Machine",
                textInfo = "6 Units"
            )
            Spacer(modifier = Modifier.width(15.dp))
            AppliancesCardWithText(
                image = painterResource(id = R.drawable.ic_light_bulb_on),
                icon = painterResource(id = R.drawable.ic_ellipse_undefined),
                title = "All Lights",
                textInfo = "18 Units"
            )
            Spacer(modifier = Modifier.width(15.dp))
            AppliancesCardWithText(
                image = painterResource(id = R.drawable.ic_all_lights),
                icon = painterResource(id = R.drawable.ic_ellipse_undefined),
                title = "All Lights",
                textInfo = "26 Units"
            )
        }


    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun AppliancesCardWithText(
    image: Painter,
    icon: Painter,
    title: String,
    textInfo: String,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Card(
            modifier = Modifier
                .width(74.dp)
                .height(74.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = icon,
                    contentDescription = "icon1",
                    modifier = Modifier.align(Alignment.End)
                )
                Image(
                    painter = image,
                    contentDescription = "icon2"
                )


            }

        }
        Spacer(modifier = Modifier.height(15.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = title,
                    style = TextStyle(fontSize = 12.sp),
                )
            }
            Text(text = textInfo, style = TextStyle(fontSize = 11.sp))
        }
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////









