package com.master_details_view_api_filter.base.api.meal_api

import com.master_details_view_api_filter.base.data.remote.FetchMealById
import com.master_details_view_api_filter.base.data.remote.FilteredMeal
import com.master_details_view_api_filter.base.data.remote.MealByCategory
import com.master_details_view_api_filter.base.data.remote.MealsByArea
import retrofit2.Response
import javax.inject.Inject

class MealApiImpl @Inject constructor(private val mealApiService: MealApiService) :
    MealApiRepository {

    override suspend fun getMealByCategory(query: String): Response<MealByCategory> =
        mealApiService.getMealByCategory(query)

    override suspend fun getMealByArea(query: String): Response<MealsByArea> =
        mealApiService.getMealByArea(query)

    override suspend fun getMealBySelectionArea(query: String): Response<FilteredMeal> =
        mealApiService.getMealBySelectedArea(query)

    override suspend fun getMealBySelectionCategory(query: String): Response<FilteredMeal> =
        mealApiService.getMealBySelectedCategory(query)

    override suspend fun getMealById(query: String): Response<FetchMealById> =
        mealApiService.getMealById(query)


}