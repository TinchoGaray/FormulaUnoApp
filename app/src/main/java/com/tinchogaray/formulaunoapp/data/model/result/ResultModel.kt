package com.tinchogaray.formulaunoapp.data.model.result

import com.google.gson.annotations.SerializedName
import com.tinchogaray.formulaunoapp.data.model.constructor.ConstructorModel
import com.tinchogaray.formulaunoapp.data.model.driver.DriverModel

data class ResultModel(
    val number: String,
    val position: String,
    val points: String,
    @SerializedName("Driver") val driver: DriverModel,
    @SerializedName("Constructor") val constructor: ConstructorModel,
    val grid: String,
    val laps: String,
    val status: String,
    @SerializedName("Time") val finalTime: ResultTimeModel,
    @SerializedName("FastestLap") val fastestLap: ConstructorModel
)