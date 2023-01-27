package com.tinchogaray.formulaunoapp.data.network

import com.tinchogaray.formulaunoapp.data.model.Driver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DriverService @Inject constructor(private val api: DriversApiClient) {

    suspend fun getAllDrivers(): List<Driver> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllDrivers()
            val body = response.body()
            body?.mrData?.driverTable?.drivers ?: emptyList()
        }
    }
}