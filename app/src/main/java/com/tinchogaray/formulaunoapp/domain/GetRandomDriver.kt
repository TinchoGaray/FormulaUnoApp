package com.tinchogaray.formulaunoapp.domain

import com.tinchogaray.formulaunoapp.data.DriversRepository
import com.tinchogaray.formulaunoapp.data.model.Drivers
import com.tinchogaray.formulaunoapp.data.model.DriversProvider

class GetRandomDriver {

    private val repository = DriversRepository()

    operator fun invoke(): Drivers? {
        val allDrivers = DriversProvider.drivers
        return if (allDrivers.isNotEmpty()) {
            val randomNumber = (allDrivers.indices).random()
            allDrivers[randomNumber]
        } else {
            null
        }
    }
}