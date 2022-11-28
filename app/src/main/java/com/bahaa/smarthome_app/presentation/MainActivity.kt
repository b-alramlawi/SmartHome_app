package com.bahaa.smarthome_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bahaa.smarthome_app.presentation.all_appliances_screen.AllAppliancesScreen
import com.bahaa.smarthome_app.presentation.control_screen.ControlScreen
import com.bahaa.smarthome_app.presentation.dashboard_screen.DashboardScreen
import com.bahaa.smarthome_app.presentation.usage_screen.UsageScreen
import com.bahaa.smarthome_app.presentation.splash_screen.SplashScreen
import com.bahaa.smarthome_app.presentation.ui.theme.SmartHome_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartHome_appTheme {

                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.UsageScreen.route
                    ) {

                        composable(Screen.SplashScreen.route) {
                            SplashScreen(navController = navController)
                        }


                        composable(
                            route = Screen.DashboardScreen.route
                        ) {
                            DashboardScreen(navController)
                        }
                        composable(
                            route = Screen.UsageScreen.route
                        ) {
                            UsageScreen(navController)
                        }
                        composable(
                            route = Screen.AllAppliancesScreen.route
                        ) {
                            AllAppliancesScreen(navController)
                        }
                        composable(
                            route = Screen.ControlScreen.route
                        ) {
                            ControlScreen(navController)
                        }


                    }
                }

            }
        }
    }
}
