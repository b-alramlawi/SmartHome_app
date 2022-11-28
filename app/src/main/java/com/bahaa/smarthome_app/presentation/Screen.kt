package com.bahaa.smarthome_app.presentation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object DashboardScreen : Screen("dashboard_screen")
    object UsageScreen : Screen("usage_screen")
    object AllAppliancesScreen : Screen("all_appliances_screen")
    object ControlScreen : Screen("control_screen")
}
