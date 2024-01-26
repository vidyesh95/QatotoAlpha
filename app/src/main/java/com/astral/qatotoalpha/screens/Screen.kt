package com.astral.qatotoalpha.screens

sealed class Screen(val route: String) {

    object FirstScreen : Screen("first")
    object HomeScreen : Screen("home")

}