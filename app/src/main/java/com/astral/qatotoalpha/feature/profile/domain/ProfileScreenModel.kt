package com.astral.qatotoalpha.feature.profile.domain

import androidx.compose.ui.graphics.vector.ImageVector

data class ProfileScreenModel(
    val profileId: Int,
    val profileImageVector: ImageVector,
    val profileText: String
)
