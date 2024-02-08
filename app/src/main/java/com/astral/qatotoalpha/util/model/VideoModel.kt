package com.astral.qatotoalpha.util.model

data class VideoModel(
    val videoId: String,
    val videoThumbnail: String,
    val isLive: Boolean = false,
    val profileImage: String,
    val videoTitle: String,
    val videoChannel: String,
    val videoViews: String,
    val videoDuration: String = "0 seconds",
    val videoLength: String,
    val videoUrl: String
)
