package com.astral.qatotoalpha.feature.auth.presentation.login

data class LoginState(val field: String = "") {
    fun validate(): Boolean {
        return field.isNotEmpty()
    }
}
