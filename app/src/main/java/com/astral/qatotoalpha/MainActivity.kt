package com.astral.qatotoalpha

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.astral.qatotoalpha.graphs.RootNavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
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
}
