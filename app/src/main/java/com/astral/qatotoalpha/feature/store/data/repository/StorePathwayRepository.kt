package com.astral.qatotoalpha.feature.store.data.repository

import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.feature.store.domain.model.StorePathwayModel

class StorePathwayRepository {
    fun getAllData() = listOf(
        StorePathwayModel(
            storePathwayId = "1",
            storePathwayThumbnail = R.drawable.store_item_thumbnail1,
            storePathwayTitle = "P Design",
            storePathwayPrice = "Rp 1.000.000",
            storePathwayRating = "4.5",
            storePathwayReview = "1.000",
            storePathwayDescription = "Master of the Star Spring is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            storePathwayUrl = "https://www.youtube.com/watch?v=3",
            storePathwayRecentRank = 3,
            storePathwayPopularityRank = 3,
            storePathwayRank = 1,
            storePathwayTrendingRank = 3
        ),
        StorePathwayModel(
            storePathwayId = "2",
            storePathwayThumbnail = R.drawable.store_item_thumbnail2,
            storePathwayTitle = "Dragon's Disciple",
            storePathwayPrice = "Rp 2.000.000",
            storePathwayRating = "4.0",
            storePathwayReview = "2.000",
            storePathwayDescription = "Dragon's Disciple is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            storePathwayUrl = "https://www.youtube.com/watch?v=2",
            storePathwayRecentRank = 2,
            storePathwayPopularityRank = 2,
            storePathwayRank = 2,
            storePathwayTrendingRank = 2
        ),
        StorePathwayModel(
            storePathwayId = "3",
            storePathwayThumbnail = R.drawable.store_item_thumbnail3,
            storePathwayTitle = "God Troubles Me Season 3",
            storePathwayPrice = "Rp 3.000.000",
            storePathwayRating = "4.5",
            storePathwayReview = "3.000",
            storePathwayDescription = "God Troubles Me Season 3 is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            storePathwayUrl = "https://www.youtube.com/watch?v=1",
            storePathwayRecentRank = 1,
            storePathwayPopularityRank = 1,
            storePathwayRank = 3,
            storePathwayTrendingRank = 1
        ),
        StorePathwayModel(
            storePathwayId = "4",
            storePathwayThumbnail = R.drawable.store_item_thumbnail4,
            storePathwayTitle = "R.E.D (Rescue Eternal Desert)",
            storePathwayPrice = "Rp 4.000.000",
            storePathwayRating = "4.0",
            storePathwayReview = "4.000",
            storePathwayDescription = "R.E.D (Rescue Eternal Desert) is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            storePathwayUrl = "https://www.youtube.com/watch?v=4",
            storePathwayRecentRank = 5,
            storePathwayPopularityRank = 5,
            storePathwayRank = 4,
            storePathwayTrendingRank = 5
        ),
        StorePathwayModel(
            storePathwayId = "5",
            storePathwayThumbnail = R.drawable.store_item_thumbnail5,
            storePathwayTitle = "The Last of Us",
            storePathwayPrice = "Rp 5.000.000",
            storePathwayRating = "4.5",
            storePathwayReview = "5.000",
            storePathwayDescription = "The Last of Us is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            storePathwayUrl = "https://www.youtube.com/watch?v=5",
            storePathwayRecentRank = 4,
            storePathwayPopularityRank = 4,
            storePathwayRank = 5,
            storePathwayTrendingRank = 4
        ),
        StorePathwayModel(
            storePathwayId = "6",
            storePathwayThumbnail = R.drawable.store_item_thumbnail3,
            storePathwayTitle = "R.E.D (Rescue Eternal Desert)",
            storePathwayPrice = "Rp 4.000.000",
            storePathwayRating = "4.0",
            storePathwayReview = "4.000",
            storePathwayDescription = "R.E.D (Rescue Eternal Desert) is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            storePathwayUrl = "https://www.youtube.com/watch?v=4",
            storePathwayRecentRank = 5,
            storePathwayPopularityRank = 5,
            storePathwayRank = 6,
            storePathwayTrendingRank = 5
        ),
    )
}