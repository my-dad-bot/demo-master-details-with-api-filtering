package com.master_details_view_api_filter.activities.master

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.recyclerview.widget.GridLayoutManager
import com.master_details_view_api_filter.base.ui.observeLiveData
import com.master_details_view_api_filter.databinding.ActivityMasterBinding
import com.shohoz.superApp.base.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MasterActivity"

@AndroidEntryPoint
class MasterActivity :
    BaseActivity<MasterViewModel, ActivityMasterBinding>(ActivityMasterBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showLoader()

        viewModel.getMealsByArea()
        viewModel.getMealsByCategory()

        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)

        initUI()
    }

    private fun initUI() {

        binding.spinnerArea.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.v(TAG, "AREA SPINNER ${parent!!.getItemAtPosition(position)}")
                viewModel.getMealByFilterArea(parent.getItemAtPosition(position).toString())
            }

        }

        binding.spinnerCategory.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Log.v(TAG, "Category SPINNER ${parent!!.getItemAtPosition(position)}")
                    viewModel.getMealByFilterCategory(parent.getItemAtPosition(position).toString())
                }

            }

    }

    override fun onObserveLiveData() {
        observeLiveData(viewModel.areaResponse) {
        }

        observeLiveData(viewModel.mealByFilterArea) {
            binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
            val adapter = MasterRecyclerAdapter(this, it)
            binding.recyclerView.adapter = adapter
        }

        observeLiveData(viewModel.mealByFilterCategory) {
            binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
            val adapter = MasterRecyclerAdapter(this, it)
            binding.recyclerView.adapter = adapter
        }

        observeLiveData(viewModel.categoryResponse) {
            Log.v(TAG, "Category Response: ${it.meals}")
        }

        observeLiveData(viewModel.areaData) {
            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item, it
            )

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerArea.adapter = adapter

        }

        observeLiveData(viewModel.categotyData) {
            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item, it
            )

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerCategory.adapter = adapter


            hideLoader()
        }
    }


}