package com.master_details_view_api_filter.base.ui

import android.os.Bundle
import java.util.*

interface FragmentCommunicator {

    fun startActivity(clz: Class<*>, bundle: Bundle? = null)
    fun onFragmentResume()
    fun showLoader()
    fun hideLoader()
}