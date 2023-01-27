package com.tinchogaray.formulaunoapp.domain

import com.tinchogaray.formulaunoapp.data.DriversRepository
import com.tinchogaray.formulaunoapp.data.model.Drivers
import com.tinchogaray.formulaunoapp.data.model.DriversProvider
import javax.inject.Inject

class GetRandomDriver @Inject constructor(
    private val repository: DriversRepository,
    private val driversProvider: DriversProvider) {

    operator fun invoke(): Drivers? {
        val allDrivers = driversProvider.drivers
        return if (allDrivers.isNotEmpty()) {
            val randomNumber = (allDrivers.indices).random()
            allDrivers[randomNumber]
        } else {
            null
        }
    }
}