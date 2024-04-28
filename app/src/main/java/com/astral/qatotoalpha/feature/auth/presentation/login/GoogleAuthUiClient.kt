package com.astral.qatotoalpha.feature.auth.presentation.login

import android.content.Context
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class GoogleAuthUiClient(
    private val context: Context,
    private val signInClient: SignInClient
) {
    private val auth = Firebase.auth
}