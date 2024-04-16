package com.astral.qatotoalpha

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.astral.qatotoalpha.graphs.RootNavigationGraph
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.BuildConfig
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    companion object {
        const val AUTH_PORT = 9099
        const val LOCALHOST = "10.0.2.2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        // Configure firebase auth to run against firebase emulator suite
        configureFirebaseServices()

        setContent {
            val sharedPref = getSharedPreferences(
                "myPref", Context.MODE_PRIVATE
            )
            val isContinueAcceptedFromSharedPref =
                sharedPref.getBoolean("isContinueAccepted", false)
            val navController = rememberNavController()
            RootNavigationGraph(
                navController = navController,
                isContinueAccepted = isContinueAcceptedFromSharedPref
            )
        }
    }

    private fun configureFirebaseServices() {
        if (BuildConfig.DEBUG) {
            Firebase.auth.useEmulator(LOCALHOST, AUTH_PORT)
        }
    }
}
