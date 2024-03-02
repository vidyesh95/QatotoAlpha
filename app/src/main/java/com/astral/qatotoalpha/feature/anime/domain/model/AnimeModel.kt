package com.astral.qatotoalpha.feature.anime.domain.model

import androidx.annotation.DrawableRes

data class AnimeModel(
    val videoId: String,
    @DrawableRes val videoThumbnail: Int,
    val videoTitle: String,
    val recentEpisodeRank: Int,
    val recommendedForYouRank: Int,
    val completedSeriesRank: Int,
    val trendingRank: Int,
    val newArrivalRank: Int,
    val isLive: Boolean = false,
    @DrawableRes val profileImage: Int,
    val channelName: String,
    val videoWatching: String = "0",
    val videoViews: String,
    val videoDuration: String = "0 seconds",
    val videoLength: String,
    val videoUrl: String,
    val season: Int = 1,
    val episode: Int = 1
)
