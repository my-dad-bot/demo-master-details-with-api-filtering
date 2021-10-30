package com.master_details_view_api_filter.base.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class AppPreference @Inject constructor(context: Context) {

    private var mSharedPreferences: SharedPreferences = context.getSharedPreferences("Cache", Context.MODE_PRIVATE)

    fun setKey(key: String?, value: String?) {
        mSharedPreferences.edit().putString(key, value).apply()
    }


    fun setLongKey(key: String?, value: Long) {
        mSharedPreferences.edit().putLong(key, value).apply()
    }

    fun getLongKey(key: String?): Long {
        return mSharedPreferences.getLong(key, 0)
    }

    fun setIntKey(key: String?, value: Int) {
        mSharedPreferences.edit().putInt(key, value).apply()
    }

    fun getIntKey(key: String?): Int {
        return mSharedPreferences.getInt(key, 0)
    }

    fun setKey(key: String?, value: Boolean) {
        mSharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getKey(key: String?): String? {
        return mSharedPreferences.getString(key, "")
    }

    fun getBoolenKey(key: String?): Boolean {
        return mSharedPreferences.getBoolean(key, false)
    }

    fun setDoubleKey(key: String?, value: Double) {
        mSharedPreferences.edit().putString(key, value.toString()).apply()
    }

    fun getDoubleKey(key: String?): Double {
        var temp: String? = "0"
        temp = try {
            mSharedPreferences.getString(key, "-1.0")
        } catch (ex: Exception) {
            ex.printStackTrace()
            return (-1.0f).toDouble()
        }
        return temp!!.toDouble()
    }

    fun clearSharedPreferences() {
        mSharedPreferences.edit().clear().apply()
    }

}