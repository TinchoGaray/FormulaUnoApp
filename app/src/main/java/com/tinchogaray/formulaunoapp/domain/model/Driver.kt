package com.tinchogaray.formulaunoapp.domain.model

import com.tinchogaray.formulaunoapp.data.database.entity.DriverEntity
import com.tinchogaray.formulaunoapp.data.model.DriverModel

//Modelo que va a utilizar la UI y el dominio
data class Driver(
    val driverId: String,
    val number: String,
    val code: String,
    val url: String,
    val name: String,
    val lastName: String,
    val dateOfBirth: String,
    val nationality: String
)

fun DriverModel.toDomain() = Driver(driverId, permanentNumber, code, url, name, lastName, dateOfBirth, nationality)

fun DriverEntity.toDomain() = Driver(driverId, permanentNumber, code, url, name, lastName, dateOfBirth, nationality)
