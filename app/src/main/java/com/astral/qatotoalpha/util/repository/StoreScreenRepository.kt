package com.astral.qatotoalpha.util.repository

import com.astral.qatotoalpha.util.model.StoreScreenModel

class StoreScreenRepository {
    fun getAllData() = listOf(
        StoreScreenModel(
            columnId = "1",
            columnTitle = "What's New\uD83D\uDD2C",
            columnSort = "whatsNew"
        ),
        StoreScreenModel(
            columnId = "2",
            columnTitle = "Popular\uD83D\uDC4D\uD83C\uDFFB",
            columnSort = "popular"
        ),
        StoreScreenModel(
            columnId = "3",
            columnTitle = "For You\uD83D\uDEEC",
            columnSort = "forYou"
        ),
        StoreScreenModel(
            columnId = "4",
            columnTitle = "Trending\uD83D\uDCC8",
            columnSort = "trending"
        )
    )
}