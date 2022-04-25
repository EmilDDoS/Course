package com.example.usdcourse.domain.interactor

import com.example.usdcourse.domain.entity.CourseUSD
import com.example.usdcourse.domain.repository.UsdCourseRepository
import io.reactivex.Single

class MonthlyCourseUseCase(private val usdCourseRepository: UsdCourseRepository) {
    fun execute(startTime: String, currentTime: String): Single<List<CourseUSD>>{
        return usdCourseRepository.getMonthlyCourse(startTime, currentTime)
    }
}