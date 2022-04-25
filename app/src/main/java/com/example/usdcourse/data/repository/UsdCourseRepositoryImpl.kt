package com.example.usdcourse.data.repository

import com.example.usdcourse.data.network.CbrService
import com.example.usdcourse.domain.entity.CourseUSD
import com.example.usdcourse.domain.repository.UsdCourseRepository
import io.reactivex.Single

class UsdCourseRepositoryImpl(private val cbrService: CbrService) : UsdCourseRepository {

    override fun getMonthlyCourse(startTime: String, currentTime: String): Single<List<CourseUSD>> {
        return cbrService.usdMonth(startTime, currentTime)
    }
}