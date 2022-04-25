package com.example.usdcourse.app

import android.app.Application
import com.example.usdcourse.di.AppComponent
import com.example.usdcourse.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        componentApp = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var componentApp: AppComponent
    }
}