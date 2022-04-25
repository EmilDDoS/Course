package com.example.usdcourse.data.network

import com.example.usdcourse.data.model.ValCursDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

private const val currencyCode = "R01235"

interface CbrApi {
    @GET("XML_dynamic.asp")
    fun getTodayApi(
        @Query("date_req1") startDate: String = "10/02/2020",
        @Query("date_req2") currentDate: String = "02/05/2020",
        @Query("VAL_NM_RQ") code: String = currencyCode
    ): Single<ValCursDto>
}



