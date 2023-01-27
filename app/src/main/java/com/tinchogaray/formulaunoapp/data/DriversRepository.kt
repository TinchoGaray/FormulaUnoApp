package com.tinchogaray.formulaunoapp.data

import com.tinchogaray.formulaunoapp.data.model.Drivers
import com.tinchogaray.formulaunoapp.data.model.DriversProvider
import com.tinchogaray.formulaunoapp.data.network.DriversService

class DriversRepository {

    private val api = DriversService()

    suspend fun getAllDrivers(): List<Drivers> {
        val drivers = api.getAllDrivers()
        DriversProvider.drivers = drivers
        return drivers
    }
}