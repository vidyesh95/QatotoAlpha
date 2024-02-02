package com.astral.qatotoalpha.util

sealed class Screen(val route: String) {

    object FirstScreen : Screen("first_screen")
    object MainScreen : Screen("main_screen")
}