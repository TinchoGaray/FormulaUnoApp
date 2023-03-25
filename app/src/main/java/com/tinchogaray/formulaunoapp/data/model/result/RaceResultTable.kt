package com.tinchogaray.formulaunoapp.data.model.result

import com.google.gson.annotations.SerializedName

data class RaceResultTable (
    val season: String,
    @SerializedName("Races") val races: List<RaceResultModel>
)
