package com.example.usdcourse.data.network

import com.example.usdcourse.domain.entity.CourseUSD
import io.reactivex.Single

interface CbrService {

    fun usdMonth (startTime: String, currentTime: String): Single<List<CourseUSD>>

}