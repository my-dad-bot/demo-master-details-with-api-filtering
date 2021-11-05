package com.master_details_view_api_filter.base.api.meal_api

import com.master_details_view_api_filter.base.data.remote.FetchMealById
import com.master_details_view_api_filter.base.data.remote.FilteredMeal
import com.master_details_view_api_filter.base.data.remote.MealByCategory
import com.master_details_view_api_filter.base.data.remote.MealsByArea
import retrofit2.Response

interface MealApiRepository {

    suspend fun getMealByCategory(query :String): Response<MealByCategory>

    suspend fun getMealByArea(query :String): Response<MealsByArea>

    suspend fun getMealBySelectionArea(query :String): Response<FilteredMeal>

    suspend fun getMealBySelectionCategory(query :String): Response<FilteredMeal>

    suspend fun getMealById(query :String): Response<FetchMealById>
}