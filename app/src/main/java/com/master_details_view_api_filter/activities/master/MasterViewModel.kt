package com.master_details_view_api_filter.activities.master

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.master_details_view_api_filter.base.api.meal_api.MealApiRepository
import com.master_details_view_api_filter.base.data.local.AppPreference
import com.master_details_view_api_filter.base.data.remote.MealByCategory
import com.master_details_view_api_filter.base.data.remote.MealsByArea
import com.shohoz.superApp.base.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MasterViewModel @Inject constructor(
    private val mealApiRepository: MealApiRepository
) : BaseViewModel() {
    var categoryResponse = MutableLiveData<MealByCategory>()
    var areaResponse = MutableLiveData<MealsByArea>()

    fun getMealsByCategory()= viewModelScope.launch (handler) {
        mealApiRepository.getMealByCategory("list").let{
            if (it.isSuccessful){
                categoryResponse.value = it.body();
            }else{
                messages.value = it.message();
            }
        }
    }

    fun getMealsByArea()= viewModelScope.launch (handler) {
        mealApiRepository.getMealByArea("list").let{
            if (it.isSuccessful){
                areaResponse.value = it.body();
            }else{
                messages.value = it.message();
            }
        }
    }
}