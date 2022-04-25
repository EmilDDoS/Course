package com.example.usdcourse.data.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "http://www.cbr.ru/scripts/"

@Module
class ApiFactory {

    @Singleton
    @get:Provides
    val instance: CbrApi
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CbrApi::class.java)
}