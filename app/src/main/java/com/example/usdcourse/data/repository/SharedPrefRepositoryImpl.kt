package com.example.usdcourse.data.repository

import com.example.usdcourse.data.sharedpreferences.SharedPref
import com.example.usdcourse.domain.repository.SharedPrefRepository

class SharedPrefRepositoryImpl(private val sharedPref: SharedPref): SharedPrefRepository {

    override fun saveDate(float: Float) {
        sharedPref.saveDate(float)
    }

    override fun getData(): Float {
        return sharedPref.getData()
    }
}