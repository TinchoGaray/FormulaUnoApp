package com.tinchogaray.formulaunoapp.data

import com.tinchogaray.formulaunoapp.data.database.dao.DriverDao
import com.tinchogaray.formulaunoapp.data.database.entity.DriverEntity
import com.tinchogaray.formulaunoapp.data.network.driver.DriverService
import com.tinchogaray.formulaunoapp.domain.model.Driver
import com.tinchogaray.formulaunoapp.domain.model.toDomain
import javax.inject.Inject

class DriversRepository @Inject constructor(
    private val api: DriverService,
    private val driverDao: DriverDao) {

    suspend fun getAllDriversFromApi(): List<Driver> {
        val response = api.getAllDrivers()
        return response.map { it.toDomain() }
    }

    suspend fun getAllDriversFromDatabase(): List<Driver> {
        val response = driverDao.getAllDrivers()
        return response.map { it.toDomain() }
    }

    suspend fun insertDrivers(drivers: List<DriverEntity>) {
        driverDao.insertAll(drivers)
    }

    suspend fun clearAllDrivers() {
        driverDao.removeAllDrivers()
    }
}