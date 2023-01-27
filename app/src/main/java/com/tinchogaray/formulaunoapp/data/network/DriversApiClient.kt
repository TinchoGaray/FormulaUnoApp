package com.tinchogaray.formulaunoapp.data.network

import com.tinchogaray.formulaunoapp.data.model.DriversResponse
import retrofit2.Response
import retrofit2.http.GET

interface DriversApiClient {

    @GET("api/f1/2022/drivers.json")
    suspend fun getAllDrivers(): Response<DriversResponse>
}