package com.astral.qatotoalpha.util.repository

import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.util.model.ProductModel

class ProductRepository {
    fun getAllData() = listOf(
        ProductModel(
            productId = "1",
            productThumbnail = R.drawable.store_item_thumbnail1,
            productTitle = "Master of the Star Spring",
            productPrice = "Rp 1.000.000",
            productRating = "4.5",
            productReview = "1.000",
            productDescription = "Master of the Star Spring is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            productUrl = "https://www.youtube.com/watch?v=3",
            productRecentRank = 3,
            productPopularityRank = 3,
            productRank = 1,
            productTrendingRank = 3
        ),
        ProductModel(
            productId = "2",
            productThumbnail = R.drawable.store_item_thumbnail2,
            productTitle = "Dragon's Disciple",
            productPrice = "Rp 2.000.000",
            productRating = "4.0",
            productReview = "2.000",
            productDescription = "Dragon's Disciple is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            productUrl = "https://www.youtube.com/watch?v=2",
            productRecentRank = 2,
            productPopularityRank = 2,
            productRank = 2,
            productTrendingRank = 2
        ),
        ProductModel(
            productId = "3",
            productThumbnail = R.drawable.store_item_thumbnail3,
            productTitle = "God Troubles Me Season 3",
            productPrice = "Rp 3.000.000",
            productRating = "4.5",
            productReview = "3.000",
            productDescription = "God Troubles Me Season 3 is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            productUrl = "https://www.youtube.com/watch?v=1",
            productRecentRank = 1,
            productPopularityRank = 1,
            productRank = 3,
            productTrendingRank = 1
        ),
        ProductModel(
            productId = "4",
            productThumbnail = R.drawable.store_item_thumbnail4,
            productTitle = "R.E.D (Rescue Eternal Desert)",
            productPrice = "Rp 4.000.000",
            productRating = "4.0",
            productReview = "4.000",
            productDescription = "R.E.D (Rescue Eternal Desert) is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            productUrl = "https://www.youtube.com/watch?v=4",
            productRecentRank = 5,
            productPopularityRank = 5,
            productRank = 4,
            productTrendingRank = 5
        ),
        ProductModel(
            productId = "5",
            productThumbnail = R.drawable.store_item_thumbnail5,
            productTitle = "P Design",
            productPrice = "Rp 5.000.000",
            productRating = "4.5",
            productReview = "5.000",
            productDescription = "P Design is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            productUrl = "https://www.youtube.com/watch?v=5",
            productRecentRank = 4,
            productPopularityRank = 4,
            productRank = 5,
            productTrendingRank = 4
        ),
        ProductModel(
            productId = "6",
            productThumbnail = R.drawable.store_item_thumbnail3,
            productTitle = "The Last of Us",
            productPrice = "Rp 6.000.000",
            productRating = "4.5",
            productReview = "6.000",
            productDescription = "The Last of Us is a great product for you to buy. It has a great quality and a great price. You can buy it now and get a great discount.",
            productUrl = "https://www.youtube.com/watch?v=6",
            productRecentRank = 6,
            productPopularityRank = 6,
            productRank = 6,
            productTrendingRank = 6
        ),
    )
}