package com.tinchogaray.formulaunoapp.domain.driver

import com.tinchogaray.formulaunoapp.data.DriversRepository
import com.tinchogaray.formulaunoapp.domain.model.Driver
import javax.inject.Inject

class GetRandomDriver @Inject constructor(private val repository: DriversRepository) {

    suspend operator fun invoke(): Driver? {
        val allDrivers = repository.getAllDriversFromDatabase()
        return if (allDrivers.isNotEmpty()) {
            val randomNumber = (allDrivers.indices).random()
            allDrivers[randomNumber]
        } else {
            null
        }
    }
}