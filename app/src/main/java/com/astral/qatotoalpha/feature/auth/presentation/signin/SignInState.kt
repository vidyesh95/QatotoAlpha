package com.astral.qatotoalpha.feature.auth.presentation.signin

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInErrorMessage: String? = null
)
