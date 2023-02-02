package com.tinchogaray.formulaunoapp.data.network.driver

import com.tinchogaray.formulaunoapp.data.model.driver.DriversResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DriversApiClient {

    @GET("api/f1/{year}/drivers.json")
    suspend fun getAllDrivers(@Path("year") year: String): Response<DriversResponse>
}