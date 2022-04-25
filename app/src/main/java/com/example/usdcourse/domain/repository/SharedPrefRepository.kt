package com.example.usdcourse.domain.repository

interface SharedPrefRepository {

    fun saveDate(float: Float)

    fun getData(): Float
}