package com.master_details_view_api_filter.activities.master

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.util.Log
import com.master_details_view_api_filter.R
import com.master_details_view_api_filter.activities.splash.SplashViewModel
import com.master_details_view_api_filter.base.ui.observeLiveData
import com.master_details_view_api_filter.databinding.ActivityMasterBinding
import com.master_details_view_api_filter.databinding.ActivitySplashBinding
import com.shohoz.superApp.base.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MasterActivity"

@AndroidEntryPoint
class MasterActivity : BaseActivity<MasterViewModel, ActivityMasterBinding>(ActivityMasterBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master)
    }

    override fun onObserveLiveData() {
        observeLiveData(viewModel.areaResponse){
            Log.v(TAG, "RESPONSE ACTIVITY AREA: "+it.meals)
        }

        observeLiveData(viewModel.categoryResponse){
            Log.v(TAG, "RESPONSE ACTIVITY CAT: "+it.meals)
        }
    }
}