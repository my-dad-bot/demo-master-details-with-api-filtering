package com.master_details_view_api_filter.base.data.remote

import com.google.gson.annotations.SerializedName

data class MealByCategory(
    @SerializedName("meals") val meals: List<MealC>
)

data class MealC(
    @SerializedName("strCategory") val strCategory: String
)