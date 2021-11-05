package com.master_details_view_api_filter.activities.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.master_details_view_api_filter.activities.master.MasterActivity
import com.master_details_view_api_filter.databinding.ActivitySplashBinding
import com.shohoz.superApp.base.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding> (ActivitySplashBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MasterActivity::class.java))
            finish()
        }, 3000)
    }

}