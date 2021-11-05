package com.master_details_view_api_filter.base.api.meal_api

import com.master_details_view_api_filter.base.data.remote.FetchMealById
import com.master_details_view_api_filter.base.data.remote.FilteredMeal
import com.master_details_view_api_filter.base.data.remote.MealByCategory
import com.master_details_view_api_filter.base.data.remote.MealsByArea
import retrofit2.Response
import retrofit2.http.*

interface MealApiService {
    @GET("list.php")
    suspend fun getMealByCategory(
        @Query("c") query: String,
    ): Response<MealByCategory>


    @GET("list.php")
    suspend fun getMealByArea(
        @Query("a") query: String,
    ): Response<MealsByArea>

    @GET("filter.php")
    suspend fun getMealBySelectedCategory(
        @Query("c") query: String,
    ): Response<FilteredMeal>

    @GET("filter.php")
    suspend fun getMealBySelectedArea(
        @Query("a") query: String,
    ): Response<FilteredMeal>

    @GET("lookup.php?")
    suspend fun getMealById(
        @Query("i") query: String,
    ): Response<FetchMealById>
}