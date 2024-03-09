package com.astral.qatotoalpha.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.astral.qatotoalpha.feature.auth.presentation.forgotpass.ForgotPassScreen
import com.astral.qatotoalpha.feature.auth.presentation.login.LoginScreen
import com.astral.qatotoalpha.feature.auth.presentation.loginwithpass.LoginWithPassScreen
import com.astral.qatotoalpha.feature.auth.presentation.newpass.NewPassScreen
import com.astral.qatotoalpha.feature.auth.presentation.register.RegisterScreen
import com.astral.qatotoalpha.util.Screen


@Composable
fun AuthNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.AUTH_GRAPH,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen()
        }
        composable(route = Screen.LoginWithPassScreen.route) {
            LoginWithPassScreen()
        }
        composable(route = Screen.ForgotPassScreen.route) {
            ForgotPassScreen()
        }
        composable(route = Screen.NewPassScreen.route) {
            NewPassScreen()
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen()
        }
    }
}
