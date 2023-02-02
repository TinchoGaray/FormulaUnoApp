package com.tinchogaray.formulaunoapp.data.network.schedule

import com.tinchogaray.formulaunoapp.data.model.race.ScheduleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ScheduleApiClient {

    @GET("api/f1/{year}.json")
    suspend fun getYearSchedules(@Path("year") year: String): Response<ScheduleResponse>
}