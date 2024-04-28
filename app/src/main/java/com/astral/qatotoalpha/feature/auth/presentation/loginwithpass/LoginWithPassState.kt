package com.astral.qatotoalpha.feature.auth.presentation.loginwithpass

data class LoginWithPassState(val field: String = "") {
    fun validate(): Boolean {
        return field.isNotEmpty()
    }
}
