package com.tinchogaray.formulaunoapp.data.network.driver

import com.tinchogaray.formulaunoapp.data.model.driver.DriverModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DriverService @Inject constructor(private val api: DriversApiClient) {

    suspend fun getAllDrivers(): List<DriverModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllDrivers("2022")
            val body = response.body()
            body?.mrDataDrivers?.driverTable?.drivers ?: emptyList()
        }
    }
}