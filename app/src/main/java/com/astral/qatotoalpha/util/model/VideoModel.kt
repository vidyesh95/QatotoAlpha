package com.astral.qatotoalpha.util.model

import androidx.annotation.DrawableRes

data class VideoModel(
    val videoId: String,
    val isLive: Boolean = false,
    @DrawableRes val videoThumbnail: Int,
    @DrawableRes val profileImage: Int,
    val videoTitle: String,
    val channelName: String,
    val videoWatching: String = "0",
    val videoViews: String,
    val videoDuration: String = "0 seconds",
    val videoLength: String,
    val videoUrl: String
)
