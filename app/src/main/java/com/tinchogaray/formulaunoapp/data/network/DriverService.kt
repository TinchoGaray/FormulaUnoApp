package com.tinchogaray.formulaunoapp.data.network

import com.tinchogaray.formulaunoapp.data.model.DriverModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DriverService @Inject constructor(private val api: DriversApiClient) {

    suspend fun getAllDrivers(): List<DriverModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllDrivers()
            val body = response.body()
            body?.mrData?.driverTable?.drivers ?: emptyList()
        }
    }
}