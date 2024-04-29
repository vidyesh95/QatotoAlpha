package com.astral.qatotoalpha.feature.auth.presentation.signin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    fun onSignInResult(signInResult: SignInResult) {
        _state.update {
            it.copy(
                isSignInSuccessful = signInResult.data != null,
                signInErrorMessage = signInResult.errorMessage
            )
        }
    }

    fun resetState() {
        _state.update { SignInState() }
    }
}