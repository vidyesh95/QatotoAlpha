package com.astral.qatotoalpha.screens

sealed class Screen(val route: String) {

    object FirstScreen : Screen("first")
    object MainScreen : Screen("main")
    object HomeScreen : Screen("home")
    object AnimeScreen : Screen("anime")
    object CreateScreen : Screen("create")
    object StoreScreen : Screen("store")
    object ShortsScreen : Screen("shorts")

}