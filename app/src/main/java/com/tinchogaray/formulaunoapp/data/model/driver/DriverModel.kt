package com.tinchogaray.formulaunoapp.data.model.driver

import com.google.gson.annotations.SerializedName

data class DriverModel(
    val driverId: String,
    val permanentNumber: String,
    val code: String,
    val url: String,
    @SerializedName("givenName") val name: String,
    @SerializedName("familyName") val lastName: String,
    val dateOfBirth: String,
    val nationality: String
)
