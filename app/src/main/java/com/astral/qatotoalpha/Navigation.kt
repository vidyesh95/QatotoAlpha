package com.astral.qatotoalpha

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.astral.qatotoalpha.screens.FirstScreen
import com.astral.qatotoalpha.screens.HomeScreen
import com.astral.qatotoalpha.screens.Screen

@Composable
fun Navigation(isContinueAccepted: Boolean) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if (isContinueAccepted == false) {
            Screen.FirstScreen.route
        } else {
            Screen.HomeScreen.route
        }
    ) {
        composable(route = Screen.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
    }
}