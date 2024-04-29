package com.astral.qatotoalpha

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.astral.qatotoalpha.feature.auth.presentation.signin.GoogleAuthUiClient
import com.astral.qatotoalpha.feature.auth.presentation.signin.SignInViewModel
import com.astral.qatotoalpha.graphs.RootNavigationGraph
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.BuildConfig
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    companion object {
        const val AUTH_PORT = 9150
        const val LOCALHOST = "127.0.0.1"
    }

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            signInClient = Identity.getSignInClient(applicationContext)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        // Configure firebase auth to run against firebase emulator suite
        //configureFirebaseServices()

        setContent {
            val sharedPref = getSharedPreferences(
                "myPref", Context.MODE_PRIVATE
            )
            val isContinueAcceptedFromSharedPref =
                sharedPref.getBoolean("isContinueAccepted", false)
            val navController = rememberNavController()

            val signInViewModel = viewModel<SignInViewModel>()
            val signInState by signInViewModel.state.collectAsStateWithLifecycle()

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = { result ->
                    if (result.resultCode == RESULT_OK) {
                        lifecycleScope.launch {
                            val signInResult = googleAuthUiClient.signInWithIntent(
                                intent = result.data ?: return@launch
                            )
                            signInViewModel.onSignInResult(signInResult)
                        }
                    }
                }
            )

            val onContinueWithGoogleClick: () -> Unit = {
                lifecycleScope.launch {
                    val signInIntentSender = googleAuthUiClient.signIn()
                    launcher.launch(
                        IntentSenderRequest
                            .Builder(signInIntentSender ?: return@launch)
                            .build()
                    )
                }
            }

            RootNavigationGraph(
                navController = navController,
                isContinueAccepted = isContinueAcceptedFromSharedPref,
                signInState = signInState,
                onContinueWithGoogleClick = onContinueWithGoogleClick
            )
        }
    }

    private fun configureFirebaseServices() {
        if (BuildConfig.DEBUG) {
            Firebase.auth.useEmulator(LOCALHOST, AUTH_PORT)
        }
    }
}
