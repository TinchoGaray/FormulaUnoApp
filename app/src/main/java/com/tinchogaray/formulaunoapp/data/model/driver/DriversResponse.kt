package com.tinchogaray.formulaunoapp.data.model.driver

import com.google.gson.annotations.SerializedName

data class DriversResponse(
    @SerializedName("MRData") val mrDataDrivers: MrDataDriverResponse
)

data class MrDataDriverResponse(
    val limit: String,
    val total: String,
    val offset: String,
    @SerializedName("DriverTable") val driverTable: DriverTable
)