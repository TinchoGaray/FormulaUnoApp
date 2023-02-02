package com.tinchogaray.formulaunoapp.data.model.race

import com.google.gson.annotations.SerializedName

data class RaceModel(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    @SerializedName("Circuit") val circuit: CircuitModel,
    val date: String,
    val time: String,
    @SerializedName("FirstPractice") val firstPractice: RaceSchedule,
    @SerializedName("SecondPractice") val secondPractice: RaceSchedule,
    @SerializedName("ThirdPractice") val thirdPractice: RaceSchedule,
    @SerializedName("Qualifying") val qualifying: RaceSchedule
)
