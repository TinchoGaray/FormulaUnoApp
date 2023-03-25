package com.tinchogaray.formulaunoapp.data.model.result

import com.google.gson.annotations.SerializedName
import com.tinchogaray.formulaunoapp.data.model.race.CircuitModel

data class RaceResultModel(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    @SerializedName("Circuit") val circuit: CircuitModel,
    val date: String,
    val time: String,
    @SerializedName("Results") val results: List<ResultModel>
)
