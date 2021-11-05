package com.shohoz.superApp.base.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.master_details_view_api_filter.base.ui.CustomAnimatedLoader
import com.master_details_view_api_filter.base.ui.FragmentCommunicator
import com.master_details_view_api_filter.base.ui.observeLiveData
import java.lang.reflect.ParameterizedType


abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding>(val bindingFactory: (LayoutInflater) -> VB) :
    AppCompatActivity(),
    FragmentCommunicator {

    protected lateinit var viewModel: VM
    val binding: VB by lazy { bindingFactory(layoutInflater) }
    private lateinit var loader: CustomAnimatedLoader

    open fun onObserveLiveData() {}

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClass(): Class<VM> {
        val type =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VM>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        viewModel = ViewModelProvider(this).get(getViewModelClass())
        setContentView(binding.root)
        onObserveLiveData()

        loader = CustomAnimatedLoader(this)

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setHomeButtonEnabled(false)
        }

        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setHomeButtonEnabled(true)
            } else {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                supportActionBar?.setHomeButtonEnabled(false)
            }
        }

        observeLiveData(viewModel.messages) {
            showSnackBar(it, Snackbar.LENGTH_SHORT)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun startActivity(clz: Class<*>, bundle: Bundle?) {
        val intent = Intent(this, clz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    override fun onFragmentResume() {}

    fun showSnackBar(text: String, length: Int) {
        val snackBar = Snackbar.make(
            findViewById(android.R.id.content),
            text,
            length
        )
        snackBar.show()
    }

    fun View.showSnackBar(
        view: View,
        msg: String,
        length: Int,
        actionMessage: CharSequence?,
        action: (View) -> Unit
    ) {
        val snackbar = Snackbar.make(view, msg, length)
        if (actionMessage != null) {
            snackbar.setAction(actionMessage) {
                action(this)
            }.show()
        } else {
            snackbar.show()
        }
    }

    override fun showLoader() {
        try {
            loader.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        loader.setCancelable(false)
        loader.show()
    }

    override fun hideLoader() {
        try {
            loader.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}