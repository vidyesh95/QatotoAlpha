package com.astral.qatotoalpha.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.astral.qatotoalpha.feature.auth.presentation.signin.SignInState
import com.astral.qatotoalpha.feature.auth.presentation.signin.SignInViewModel
import com.astral.qatotoalpha.feature.auth.presentation.signin.UserData
import com.astral.qatotoalpha.feature.firsttime.presentation.FirstScreen
import com.astral.qatotoalpha.feature.navbar.presentation.MainScreen
import com.astral.qatotoalpha.util.Screen

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    isContinueAccepted: Boolean?,
    signInViewModel: SignInViewModel,
    signInState: SignInState,
    onContinueWithGoogleClick: () -> Unit,
    userData: UserData?,
    onSignOut: () -> Unit
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT_GRAPH,
        startDestination = if (isContinueAccepted == false) {
            Screen.FirstScreen.route
        } else {
            Screen.MainScreen.route
        }
    ) {
        composable(route = Screen.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(
                signInViewModel = signInViewModel,
                signInState = signInState,
                onContinueWithGoogleClick = onContinueWithGoogleClick,
                userData = userData,
                onSignOut = onSignOut
            )
        }
        authNavigationGraph(
            navController = navController,
            signInViewModel = signInViewModel,
            signInState = signInState,
            onContinueWithGoogleClick = onContinueWithGoogleClick
        )
    }
}

object Graph {
    const val ROOT_GRAPH = "root_graph"
    const val MAIN_GRAPH = "main_nav_graph"
    const val PROFILE_GRAPH = "profile_nav_graph"
    const val AUTH_GRAPH = "auth_nav_graph"
}
