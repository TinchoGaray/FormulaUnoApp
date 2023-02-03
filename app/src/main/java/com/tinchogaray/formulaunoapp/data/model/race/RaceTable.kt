package com.tinchogaray.formulaunoapp.data.model.race

import com.google.gson.annotations.SerializedName

data class RaceTable(
    val season: String,
    @SerializedName("Races") val races: List<RaceScheduleModel>
)