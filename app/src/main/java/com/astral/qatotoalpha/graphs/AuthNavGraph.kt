package com.astral.qatotoalpha.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.astral.qatotoalpha.feature.auth.presentation.forgotpass.ForgotPassScreen
import com.astral.qatotoalpha.feature.auth.presentation.login.LoginScreen
import com.astral.qatotoalpha.feature.auth.presentation.loginwithpass.LoginWithPassScreen
import com.astral.qatotoalpha.feature.auth.presentation.newpass.NewPassScreen
import com.astral.qatotoalpha.feature.auth.presentation.register.RegisterScreen
import com.astral.qatotoalpha.util.Screen


fun NavGraphBuilder.authNavigationGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH_GRAPH,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.LoginWithPassScreen.route) {
            LoginWithPassScreen(navController = navController)
        }
        composable(route = Screen.ForgotPassScreen.route) {
            ForgotPassScreen(navController = navController)
        }
        composable(route = Screen.NewPassScreen.route) {
            NewPassScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
    }
}
