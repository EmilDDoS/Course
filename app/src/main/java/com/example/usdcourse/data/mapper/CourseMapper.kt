package com.example.usdcourse.data.mapper

import com.example.usdcourse.data.model.ValCursDto
import com.example.usdcourse.domain.entity.CourseUSD

class CourseMapper {

    fun valCursDtoToCourseUsd(dto: ValCursDto): List<CourseUSD> {

        return dto.record.map {
            CourseUSD(
                date = it.date,
                value = it.value
            )
        }
    }
}