package com.astral.qatotoalpha.util.model

import androidx.annotation.DrawableRes

data class ShortsModel(
    val shortsId: String,
    val isLive: Boolean = false,
    @DrawableRes val shortsThumbnail: Int,
    @DrawableRes val profileImage: Int,
    val shortsTitle: String,
    val shortsChannel: String,
    val shortsViews: String,
    val shortsDuration: String = "0 seconds",
    val shortsLength: String,
    val shortsUrl: String
)
