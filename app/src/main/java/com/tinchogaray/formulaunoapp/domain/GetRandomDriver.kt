package com.tinchogaray.formulaunoapp.domain

import com.tinchogaray.formulaunoapp.data.DriversRepository
import com.tinchogaray.formulaunoapp.data.model.Driver
import com.tinchogaray.formulaunoapp.data.model.DriverProvider
import javax.inject.Inject

class GetRandomDriver @Inject constructor(
    private val repository: DriversRepository,
    private val driverProvider: DriverProvider) {

    operator fun invoke(): Driver? {
        val allDrivers = driverProvider.drivers
        return if (allDrivers.isNotEmpty()) {
            val randomNumber = (allDrivers.indices).random()
            allDrivers[randomNumber]
        } else {
            null
        }
    }
}