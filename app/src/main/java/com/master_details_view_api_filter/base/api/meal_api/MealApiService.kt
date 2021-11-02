package com.master_details_view_api_filter.base.api.meal_api

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
}