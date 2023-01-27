package com.tinchogaray.formulaunoapp.domain

import com.tinchogaray.formulaunoapp.data.DriversRepository
import com.tinchogaray.formulaunoapp.data.model.Driver
import javax.inject.Inject

class GetDrivers @Inject constructor(private val repository: DriversRepository) {

    suspend operator fun invoke(): List<Driver> = repository.getAllDrivers()
}