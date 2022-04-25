package com.example.usdcourse.di

import com.example.usdcourse.data.network.CbrService
import com.example.usdcourse.data.repository.SharedPrefRepositoryImpl
import com.example.usdcourse.data.repository.UsdCourseRepositoryImpl
import com.example.usdcourse.data.sharedpreferences.SharedPref
import com.example.usdcourse.domain.interactor.MonthlyCourseUseCase
import com.example.usdcourse.domain.interactor.SharedPrefUseCase
import com.example.usdcourse.domain.repository.SharedPrefRepository
import com.example.usdcourse.domain.repository.UsdCourseRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideUsdCourseRepository(
        cbrService: CbrService
    ): UsdCourseRepository = UsdCourseRepositoryImpl(cbrService)

    @Provides
    fun provideSharedPref(
        sharedPref: SharedPref
    ): SharedPrefRepository = SharedPrefRepositoryImpl(sharedPref)

    @Provides
    fun provideSharedPrefUseCase(
        sharedPrefRepository: SharedPrefRepository
    ): SharedPrefUseCase = SharedPrefUseCase(sharedPrefRepository)

    @Provides
    fun provideUsdCourseRepositoryUseCase(
        usdCourseRepository: UsdCourseRepository
    ): MonthlyCourseUseCase = MonthlyCourseUseCase(usdCourseRepository)
}