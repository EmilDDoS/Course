package com.example.usdcourse.di

import androidx.lifecycle.ViewModel
import com.example.usdcourse.app.AppScope
import com.example.usdcourse.app.ApplicationModule
import com.example.usdcourse.domain.interactor.SharedPrefUseCase
import com.example.usdcourse.presentation.NotificationReceiver
import dagger.Component
import dagger.android.support.AndroidSupportInjection


@AppScope
@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class,
        DomainModule::class,
        ApplicationModule::class
    ]
)
interface AppComponent {

    fun inject(notificationReceiver: NotificationReceiver)

    val mapModels: Map<Class<*>, ViewModel>
}