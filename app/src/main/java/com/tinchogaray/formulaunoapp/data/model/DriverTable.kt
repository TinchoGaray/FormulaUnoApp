package com.tinchogaray.formulaunoapp.data.model

import com.google.gson.annotations.SerializedName

data class DriverTable(
    val season: String,
    @SerializedName("Drivers") val drivers: List<Drivers>
)