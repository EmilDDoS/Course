package com.example.usdcourse.di

import androidx.lifecycle.ViewModel
import com.example.usdcourse.domain.interactor.MonthlyCourseUseCase
import com.example.usdcourse.domain.interactor.SharedPrefUseCase
import com.example.usdcourse.presentation.screens.coursescreen.CourseFragmentViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @IntoMap
    @ClassKey(CourseFragmentViewModel::class)
    @Provides
    fun getViewModel(
        monthlyCourseUseCase: MonthlyCourseUseCase,
        sharedPrefUseCase: SharedPrefUseCase
    ): ViewModel {
        return CourseFragmentViewModel(monthlyCourseUseCase, sharedPrefUseCase)
    }
}