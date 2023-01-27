package com.tinchogaray.formulaunoapp.domain

import com.tinchogaray.formulaunoapp.data.DriversRepository
import com.tinchogaray.formulaunoapp.data.model.Drivers

class GetDrivers {

    private val repository = DriversRepository()

    suspend operator fun invoke(): List<Drivers> = repository.getAllDrivers()
}