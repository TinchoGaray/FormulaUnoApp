package com.tinchogaray.formulaunoapp.data.model.race

import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("lat") val latitude: String,
    @SerializedName("long") val longitude: String,
    @SerializedName("locality") val city: String,
    val country: String
)