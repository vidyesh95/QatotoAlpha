package com.astral.qatotoalpha.feature.profile.domain

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class AccountSettingsScreenModel(
    val accountSettingsId: Int,
    val accountSettingsImageVector: ImageVector,
    @StringRes val accountSettingsText: Int
)
