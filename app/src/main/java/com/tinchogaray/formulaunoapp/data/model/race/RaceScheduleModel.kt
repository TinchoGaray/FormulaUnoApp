package com.tinchogaray.formulaunoapp.data.model.race

import com.google.gson.annotations.SerializedName

data class RaceScheduleModel(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    @SerializedName("Circuit") val circuit: CircuitModel,
    val date: String,
    val time: String,
    @SerializedName("FirstPractice") val firstPractice: RaceDate,
    @SerializedName("SecondPractice") val secondPractice: RaceDate,
    @SerializedName("ThirdPractice") val thirdPractice: RaceDate,
    @SerializedName("Qualifying") val qualifying: RaceDate
)
