package com.example.usdcourse.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun provideContext(): Context{
        return application.applicationContext
    }
}