package com.tinchogaray.formulaunoapp.domain.model

import com.tinchogaray.formulaunoapp.data.model.result.FastestLapModel

data class FastestLap (
    val rank: String,
    val lap: String,
    val time: ResultTime,
    val averageSpeed: Speed
)

fun FastestLapModel.toDomain() = FastestLap(rank, lap, time.toDomain(), averageSpeed.toDomain())
