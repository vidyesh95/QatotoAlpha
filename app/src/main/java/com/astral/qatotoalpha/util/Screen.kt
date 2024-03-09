package com.astral.qatotoalpha.util

sealed class Screen(val route: String) {

    object FirstScreen : Screen(route = "first_screen")
    object MainScreen : Screen(route = "main_screen")
    object ProfileScreen : Screen(route = "profile_screen")
    object LoginScreen : Screen(route = "login_screen")
    object LoginWithPassScreen : Screen(route = "login_with_pass_screen")
    object ForgotPassScreen : Screen(route = "forgot_pass_screen")
    object RegisterScreen : Screen(route = "register_screen")
    object NewPassScreen : Screen(route = "new_pass_screen")
}
