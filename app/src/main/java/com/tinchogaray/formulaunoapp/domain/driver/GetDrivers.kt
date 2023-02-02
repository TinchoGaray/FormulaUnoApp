package com.tinchogaray.formulaunoapp.domain.driver

import com.tinchogaray.formulaunoapp.data.DriversRepository
import com.tinchogaray.formulaunoapp.data.database.entity.toDatabase
import com.tinchogaray.formulaunoapp.domain.model.Driver
import javax.inject.Inject

class GetDrivers @Inject constructor(private val repository: DriversRepository) {

    suspend operator fun invoke(): List<Driver> {
        val drivers = repository.getAllDriversFromApi()

        return if (drivers.isNotEmpty()) {
            repository.clearAllDrivers()
            repository.insertDrivers(drivers.map { it.toDatabase() })
            drivers
        } else {
            repository.getAllDriversFromDatabase()
        }
    }
}