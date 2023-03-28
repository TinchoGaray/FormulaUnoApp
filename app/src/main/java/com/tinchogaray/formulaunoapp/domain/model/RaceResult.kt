package com.tinchogaray.formulaunoapp.domain.model

import com.tinchogaray.formulaunoapp.data.model.race.CircuitModel
import com.tinchogaray.formulaunoapp.data.model.result.RaceResultModel

data class RaceResult (
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    val circuit: CircuitModel,
    val date: String,
    val time: String,
    val results: List<Result>
)

fun RaceResultModel.toDomain() = RaceResult(season, round, url, raceName, circuit, date, time, results.map { it.toDomain() })
