package com.example.usdcourse.di

import android.content.Context
import com.example.usdcourse.data.mapper.CourseMapper
import com.example.usdcourse.data.network.ApiFactory
import com.example.usdcourse.data.network.CbrService
import com.example.usdcourse.data.network.CbrServiceImpl
import com.example.usdcourse.data.sharedpreferences.SharedPref
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCbrService(
        apiFactory: ApiFactory, courseMapper: CourseMapper
    ): CbrService = CbrServiceImpl(apiFactory, courseMapper)

    @Provides
    fun provideApiFactory(): ApiFactory = ApiFactory()

    @Provides
    fun provideCourseMapper(): CourseMapper = CourseMapper()

    @Provides
    fun provideSharedPref(context: Context): SharedPref = SharedPref(context)
}