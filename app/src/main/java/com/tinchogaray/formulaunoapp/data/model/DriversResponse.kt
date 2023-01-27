package com.tinchogaray.formulaunoapp.data.model

import com.google.gson.annotations.SerializedName

data class DriversResponse(
    @SerializedName("MRData") val mrData: MrDataResponse
)

data class MrDataResponse(
    val limit: String,
    val total: String,
    val offset: String,
    @SerializedName("DriverTable") val driverTable: DriverTable
)