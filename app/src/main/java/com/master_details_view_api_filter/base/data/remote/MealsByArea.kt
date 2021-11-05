package com.master_details_view_api_filter.base.data.remote

import com.google.gson.annotations.SerializedName

data class MealsByArea(
    @SerializedName("meals") val meals: List<MealA>
)

data class MealA(
    @SerializedName("strArea")  val strArea: String
)