package com.tinchogaray.formulaunoapp.domain.model.mapper

import com.tinchogaray.formulaunoapp.domain.model.FastestLapDriver
import com.tinchogaray.formulaunoapp.domain.model.PodiumDriver
import com.tinchogaray.formulaunoapp.domain.model.RaceResult

class RaceResultMapper {

    fun fromRaceResultToPodiumDriver(raceResult: RaceResult): MutableList<PodiumDriver> {
        val podiumDriverList = mutableListOf<PodiumDriver>()
        for (i in 0..2) {
            raceResult.results[i].let {
                podiumDriverList.add(PodiumDriver(it.driver.name, it.driver.lastName, it.points, it.constructor.constructorId, it.finalTime.time ?: "0", it.position))
            }
        }
        return podiumDriverList
    }

    fun fromRaceResultToFastestLap(raceResult: RaceResult): MutableList<FastestLapDriver> {
        val fastestLapDriverList = mutableListOf<FastestLapDriver>()
        for (i in 0..2) {
            raceResult.results[i].let {

            }
        }
        return fastestLapDriverList
    }

}
