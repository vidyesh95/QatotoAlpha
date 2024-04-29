package com.astral.qatotoalpha.feature.auth.presentation.signin


data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userID: String,
    val username: String?,
    val profilePictureUrl: String?
)