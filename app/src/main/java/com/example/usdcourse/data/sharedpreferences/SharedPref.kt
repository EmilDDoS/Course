package com.example.usdcourse.data.sharedpreferences

import android.content.Context

private const val SHARED_PREFERENCES_NAME = "shared_pref"
private const val NUMBER_KEY = "number"
const val EMPTY_NUMBER = 0f

class SharedPref(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun saveDate(float: Float) {
        sharedPreferences.edit()
            .putFloat(NUMBER_KEY, float)
            .apply()
    }

    fun getData(): Float {
        return sharedPreferences.getFloat(NUMBER_KEY, EMPTY_NUMBER)
    }
}