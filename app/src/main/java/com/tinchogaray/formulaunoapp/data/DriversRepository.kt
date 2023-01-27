package com.tinchogaray.formulaunoapp.data

import com.tinchogaray.formulaunoapp.data.model.Drivers
import com.tinchogaray.formulaunoapp.data.model.DriversProvider
import com.tinchogaray.formulaunoapp.data.network.DriversService
import javax.inject.Inject

class DriversRepository @Inject constructor(
    private val api: DriversService,
    private val driversProvider: DriversProvider){

    suspend fun getAllDrivers(): List<Drivers> {
        val drivers = api.getAllDrivers()
        driversProvider.drivers = drivers
        return drivers
    }
}