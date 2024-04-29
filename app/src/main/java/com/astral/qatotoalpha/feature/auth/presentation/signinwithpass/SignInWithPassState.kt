package com.astral.qatotoalpha.feature.auth.presentation.signinwithpass

data class SignInWithPassState(val field: String = "") {
    fun validate(): Boolean {
        return field.isNotEmpty()
    }
}
