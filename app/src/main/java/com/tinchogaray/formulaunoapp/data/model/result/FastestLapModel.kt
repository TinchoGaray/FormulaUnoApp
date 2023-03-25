package com.tinchogaray.formulaunoapp.data.model.result

import com.google.gson.annotations.SerializedName
import com.tinchogaray.formulaunoapp.data.model.race.SpeedModel

data class FastestLapModel(
    val rank: String,
    val lap: String,
    @SerializedName("Time") val time: ResultTimeModel,
    @SerializedName("AverageSpeed") val averageSpeed: SpeedModel
)
