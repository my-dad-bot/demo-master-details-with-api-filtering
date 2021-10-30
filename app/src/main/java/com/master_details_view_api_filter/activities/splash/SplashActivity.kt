package com.master_details_view_api_filter.activities.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.master_details_view_api_filter.R
import com.master_details_view_api_filter.databinding.ActivitySplashBinding
import com.shohoz.superApp.base.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding> (ActivitySplashBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showSnackBar("On Splash", Snackbar.LENGTH_INDEFINITE)
    }

}