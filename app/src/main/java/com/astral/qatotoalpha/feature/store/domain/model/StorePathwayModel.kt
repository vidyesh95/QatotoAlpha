package com.astral.qatotoalpha.feature.store.domain.model

import androidx.annotation.DrawableRes

data class StorePathwayModel(
    val storePathwayId: String,
    @DrawableRes val storePathwayThumbnail: Int,
    val storePathwayTitle: String,
    val storePathwayPrice: String,
    val storePathwayRating: String,
    val storePathwayReview: String,
    val storePathwayDescription: String,
    val storePathwayUrl: String,
    val storePathwayRecentRank: Int,
    val storePathwayPopularityRank: Int,
    val storePathwayRank: Int,
    val storePathwayTrendingRank: Int,
    /*
    val storeCategory: String,
    val storeSubCategory: String,
    val storeBrand: String,
    val storeStock: String,
    val storeWeight: String,
    val storeDimension: String,
    val storeColor: String,
    val storeSize: String,
    val storeMaterial: String,
    val storeModel: String,
    val storeWarranty: String,
    val storeCondition: String,
    */
)
