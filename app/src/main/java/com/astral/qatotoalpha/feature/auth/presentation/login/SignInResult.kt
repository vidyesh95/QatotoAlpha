package com.astral.qatotoalpha.feature.auth.presentation.login


data class SignInResult(
    //val success: Boolean,
    //val message: String,
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userID: String,
    val username: String?,
    val profilePictureUrl: String?
)