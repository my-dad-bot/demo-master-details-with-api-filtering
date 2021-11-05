package com.master_details_view_api_filter.activities.food_details.ui

import android.os.Bundle
import android.util.Log
import com.master_details_view_api_filter.base.ui.observeLiveData
import com.master_details_view_api_filter.databinding.ActivityFoodDetailsBinding
import com.master_details_view_api_filter.utils.load
import com.shohoz.superApp.base.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "FoodDetailsActivity"
@AndroidEntryPoint
class FoodDetailsActivity : BaseActivity<FoodDetailsViewModel, ActivityFoodDetailsBinding>(
    ActivityFoodDetailsBinding::inflate) {

    val mealId: String? by lazy {
        intent.getStringExtra("meal_id")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        Log.v(TAG, "MEAL ID $mealId")
        if (mealId != null)
        {
            viewModel.getMealsByCategory(mealId!!)
        }
    }

    fun setToolbar(title: String) {
        binding.includeToolbar.topAppBar.title = title
        binding.includeToolbar.topAppBar.isTitleCentered = true
        binding.includeToolbar.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
    override fun onObserveLiveData() {
        observeLiveData(viewModel.filterMealByIdResponse){
            binding.imageViewFoodImage.load(it.meals[0].strMealThumb)
            setToolbar(it.meals[0].strMeal)
            binding.textViewDescription.text = it.meals[0].strInstructions
        }

        observeLiveData(viewModel.loader){
            if (it){
                hideLoader()
            }
        }
    }
}