package com.astral.qatotoalpha.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.astral.qatotoalpha.feature.auth.presentation.signin.SignInState
import com.astral.qatotoalpha.feature.auth.presentation.signin.SignInViewModel
import com.astral.qatotoalpha.feature.auth.presentation.signin.UserData
import com.astral.qatotoalpha.feature.profile.presentation.AccountSettingsScreen
import com.astral.qatotoalpha.feature.profile.presentation.ProfileScreen
import com.astral.qatotoalpha.util.Screen

fun NavGraphBuilder.profileNavigationGraph(
    navController: NavHostController,
    signInViewModel: SignInViewModel,
    signInState: SignInState,
    onContinueWithGoogleClick: () -> Unit,
    userData: UserData?,
    onSignOut: () -> Unit
) {
    navigation(
        route = Graph.PROFILE_GRAPH,
        startDestination = Screen.ProfileScreen.route
    ) {
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(
                navController = navController,
                userData = userData
            )
        }
        composable(route = Screen.AccountSettingsScreen.route) {
            AccountSettingsScreen(
                navController = navController,
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
