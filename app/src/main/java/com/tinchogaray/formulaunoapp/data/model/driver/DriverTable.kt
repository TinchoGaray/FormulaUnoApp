package com.tinchogaray.formulaunoapp.data.model.driver

import com.google.gson.annotations.SerializedName

data class DriverTable(
    val season: String,
    @SerializedName("Drivers") val drivers: List<DriverModel>
)
