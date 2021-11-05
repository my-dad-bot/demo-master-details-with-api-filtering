package com.master_details_view_api_filter.base.data.remote

import com.google.gson.annotations.SerializedName

data class FilteredMeal(
    @SerializedName ("meals") val meals: List<SelectedMeal>
)

data class SelectedMeal(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strMealThumb") val strMealThumb: String
)