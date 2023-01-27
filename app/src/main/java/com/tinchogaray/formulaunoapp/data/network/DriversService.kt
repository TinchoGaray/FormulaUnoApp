package com.tinchogaray.formulaunoapp.data.network

import com.tinchogaray.formulaunoapp.core.RetrofitHelper
import com.tinchogaray.formulaunoapp.data.model.Drivers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DriversService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllDrivers(): List<Drivers> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(DriversApiClient::class.java).getAllDrivers()
            val body = response.body()
            body?.mrData?.driverTable?.drivers ?: emptyList()
        }
    }
}