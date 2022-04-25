package com.example.usdcourse.data.network

import com.example.usdcourse.data.mapper.CourseMapper
import com.example.usdcourse.domain.entity.CourseUSD
import io.reactivex.Single

class CbrServiceImpl(private val apiFactory: ApiFactory, private val courseMapper: CourseMapper) :
    CbrService {

    override fun usdMonth(startTime: String, currentTime: String): Single<List<CourseUSD>> {
        return apiFactory.instance.getTodayApi(
            startTime,
            currentTime
        ).map { courseMapper.valCursDtoToCourseUsd(it) }
    }

}