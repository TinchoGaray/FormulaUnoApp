package com.tinchogaray.formulaunoapp.data.model.race

import com.google.gson.annotations.SerializedName

data class CircuitModel(
    val circuitId: String,
    val url: String,
    val circuitName: String,
    @SerializedName("Location") val location: LocationModel
)