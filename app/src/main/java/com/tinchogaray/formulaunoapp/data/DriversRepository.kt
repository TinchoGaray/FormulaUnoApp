package com.tinchogaray.formulaunoapp.data

import com.tinchogaray.formulaunoapp.data.model.Driver
import com.tinchogaray.formulaunoapp.data.model.DriverProvider
import com.tinchogaray.formulaunoapp.data.network.DriverService
import javax.inject.Inject

class DriversRepository @Inject constructor(
    private val api: DriverService,
    private val driverProvider: DriverProvider){

    suspend fun getAllDrivers(): List<Driver> {
        val drivers = api.getAllDrivers()
        driverProvider.drivers = drivers
        return drivers
    }
}