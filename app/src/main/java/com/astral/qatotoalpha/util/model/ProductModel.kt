package com.astral.qatotoalpha.util.model

import androidx.annotation.DrawableRes

data class ProductModel(
    val productId: String,
    @DrawableRes val productThumbnail: Int,
    val productTitle: String,
    val productPrice: String,
    val productRating: String,
    val productReview: String,
    val productDescription: String,
    val productUrl: String,
    val productRecentRank: Int,
    val productPopularityRank: Int,
    val productRank: Int,
    val productTrendingRank: Int,
    /*
    val productCategory: String,
    val productSubCategory: String,
    val productBrand: String,
    val productStock: String,
    val productWeight: String,
    val productDimension: String,
    val productColor: String,
    val productSize: String,
    val productMaterial: String,
    val productModel: String,
    val productWarranty: String,
    val productCondition: String,
    */
)
