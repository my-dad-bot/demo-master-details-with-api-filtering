package com.master_details_view_api_filter.activities.master

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.master_details_view_api_filter.base.api.meal_api.MealApiRepository
import com.master_details_view_api_filter.base.data.remote.*
import com.shohoz.superApp.base.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MasterViewModel @Inject constructor(
    private val mealApiRepository: MealApiRepository
) : BaseViewModel() {
    var categoryResponse = MutableLiveData<MealByCategory>()
    var areaResponse = MutableLiveData<MealsByArea>()

    var mealByFilterArea = MutableLiveData<FilteredMeal>()
    var mealByFilterCategory = MutableLiveData<FilteredMeal>()

    var areasItem = mutableListOf<String>()
    var categoryItem = mutableListOf<String>()

    var areaData = MutableLiveData<MutableList<String>>()
    var categotyData = MutableLiveData<MutableList<String>>()

    fun getMealsByCategory() = viewModelScope.launch(handler) {
        loader.value = true
        mealApiRepository.getMealByCategory("list").let {
            if (it.isSuccessful) {
                loader.value = false
                categoryResponse.value = it.body();
                getCategorySpinnerData(it.body()!!.meals)
            } else {
                messages.value = it.message();
            }
        }
    }

    fun getMealByFilterArea(string: String) = viewModelScope.launch(handler) {
        loader.value = true
        mealApiRepository.getMealBySelectionArea(string).let {
            if (it.isSuccessful) {
                loader.value = false
                mealByFilterArea.value = it.body();
            } else {
                messages.value = it.message();
            }
        }
    }

    fun getMealByFilterCategory(string: String) = viewModelScope.launch(handler) {
        loader.value = true
        mealApiRepository.getMealBySelectionCategory(string).let {
            if (it.isSuccessful) {
                loader.value = false
                mealByFilterCategory.value = it.body();
            } else {
                messages.value = it.message();
            }
        }
    }

    fun getMealsByArea() = viewModelScope.launch(handler) {
        loader.value = true
        mealApiRepository.getMealByArea("list").let {
            if (it.isSuccessful) {
                loader.value = false
                areaResponse.value = it.body();
                getAreaSpinnerData(it.body()!!.meals)
            } else {
                messages.value = it.message();
            }
        }
    }

    private fun getCategorySpinnerData(meals: List<MealC>) {
        for (i in meals.indices) {
            categoryItem.add(meals[i].strCategory)
        }

        categotyData.value = categoryItem
    }

    private fun getAreaSpinnerData(meals: List<MealA>) {
        for (i in meals.indices) {
            areasItem.add(meals[i].strArea)
        }
        areaData.value = areasItem
    }

}