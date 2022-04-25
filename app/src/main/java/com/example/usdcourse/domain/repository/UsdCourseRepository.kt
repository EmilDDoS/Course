package com.example.usdcourse.domain.repository

import com.example.usdcourse.domain.entity.CourseUSD
import io.reactivex.Single

interface UsdCourseRepository {
    fun getMonthlyCourse(startTime: String, currentTime: String): Single<List<CourseUSD>>
}