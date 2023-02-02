package com.tinchogaray.formulaunoapp.data.model.race

import com.google.gson.annotations.SerializedName

data class ScheduleResponse(
    @SerializedName("MRData") val mrDataSchedules: MrDataSchedulesResponse
)

data class MrDataSchedulesResponse(
    val limit: String,
    val total: String,
    val offset: String,
    @SerializedName("RaceTable") val raceTable: RaceTable
)