package com.astral.qatotoalpha.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.astral.qatotoalpha.feature.auth.presentation.forgotpass.ForgotPassScreen
import com.astral.qatotoalpha.feature.auth.presentation.newpass.NewPassScreen
import com.astral.qatotoalpha.feature.auth.presentation.signin.SignInScreen
import com.astral.qatotoalpha.feature.auth.presentation.signin.SignInState
import com.astral.qatotoalpha.feature.auth.presentation.signinwithpass.SignInWithPassScreen
import com.astral.qatotoalpha.feature.auth.presentation.signup.SignUpScreen
import com.astral.qatotoalpha.util.Screen

fun NavGraphBuilder.authNavigationGraph(
    navController: NavHostController,
    signInState: SignInState,
    onContinueWithGoogleClick: () -> Unit
) {
    navigation(
        route = Graph.AUTH_GRAPH,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            SignInScreen(
                navController = navController,
                signInState = signInState,
                onContinueWithGoogleClick = onContinueWithGoogleClick
            )
        }
        composable(route = Screen.LoginWithPassScreen.route) {
            SignInWithPassScreen(navController = navController)
        }
        composable(route = Screen.ForgotPassScreen.route) {
            ForgotPassScreen(navController = navController)
        }
        composable(route = Screen.NewPassScreen.route) {
            NewPassScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            SignUpScreen(navController = navController)
        }
    }
}
