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

class RaceResultMapper {

    fun fromRaceResultToPodiumDriver(raceResult: RaceResult): MutableList<PodiumDriver> {
        val podiumDriverList = mutableListOf<PodiumDriver>()
        for (i in 0..2) {
            raceResult.results[i].let {
                podiumDriverList.add(PodiumDriver(it.driver.name, it.driver.lastName, it.points, it.constructor.constructorId, it.finalTime.time, it.position))
            }
        }
        return podiumDriverList
    }
}