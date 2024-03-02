package com.astral.qatotoalpha.feature.anime.data.repository

import com.astral.qatotoalpha.feature.anime.domain.model.AnimeScreenModel

class AnimeScreenRepository {
    fun getAllData() = listOf(
        AnimeScreenModel(
            rowId = "1",
            rowTitle = "Recent Episode\uD83D\uDCA1",
            rowSort = "recentEpisodeRank"
        ),
        AnimeScreenModel(
            rowId = "2",
            rowTitle = "Recommended For You\uD83D\uDD2C",
            rowSort = "recommendedForYouRank"
        ),
        AnimeScreenModel(
            rowId = "3",
            rowTitle = "Completed Series\uD83D\uDC4D\uD83C\uDFFB",
            rowSort = "completedSeriesRank"
        ),
        AnimeScreenModel(
            rowId = "4",
            rowTitle = "Trending\uD83D\uDCC8",
            rowSort = "trendingRank"
        ),
        AnimeScreenModel(
            rowId = "5",
            rowTitle = "New Arrivals\uD83D\uDEEC",
            rowSort = "newArrivalRank"
        )
    )
}