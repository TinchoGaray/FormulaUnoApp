package com.tinchogaray.formulaunoapp.data.model.result

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("MRData") val mrDataResult: MrDataResultResponse
)

data class MrDataResultResponse(
    val limit: String,
    val total: String,
    val offset: String,
    @SerializedName("RaceTable") val raceTable: RaceResultTable
)
