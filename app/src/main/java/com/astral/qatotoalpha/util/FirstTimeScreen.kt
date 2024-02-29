package com.astral.qatotoalpha.util

sealed class FirstTimeScreen(val route: String) {

    object FirstScreen : FirstTimeScreen(route = "first_screen")
    object MainScreen : FirstTimeScreen(route = "main_screen")
}