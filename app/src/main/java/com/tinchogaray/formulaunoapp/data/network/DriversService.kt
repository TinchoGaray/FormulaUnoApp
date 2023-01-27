package com.tinchogaray.formulaunoapp.data.network

import com.tinchogaray.formulaunoapp.core.RetrofitHelper
import com.tinchogaray.formulaunoapp.data.model.Drivers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DriversService @Inject constructor(private val api: DriversApiClient) {

    suspend fun getAllDrivers(): List<Drivers> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllDrivers()
            val body = response.body()
            body?.mrData?.driverTable?.drivers ?: emptyList()
        }
    }
}