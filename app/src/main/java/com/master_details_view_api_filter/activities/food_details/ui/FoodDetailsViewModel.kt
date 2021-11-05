package com.master_details_view_api_filter.activities.food_details.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.master_details_view_api_filter.base.api.meal_api.MealApiRepository
import com.master_details_view_api_filter.base.data.remote.FetchMealById
import com.shohoz.superApp.base.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailsViewModel @Inject constructor(
    private val mealApiRepository: MealApiRepository
): BaseViewModel(){

    val filterMealByIdResponse = MutableLiveData<FetchMealById>()

    fun getMealsByCategory(meal_id : String) = viewModelScope.launch(handler) {
        loader.value = true
        mealApiRepository.getMealById(meal_id).let {
            if (it.isSuccessful) {
                loader.value = false
                filterMealByIdResponse.value = it.body();

            } else {
                messages.value = it.message();
            }
        }
    }
}