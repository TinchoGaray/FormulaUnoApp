package com.tinchogaray.formulaunoapp.domain.fastestlap

import com.tinchogaray.formulaunoapp.domain.model.RaceResult

class TopFastestLapBuilder {

    fun getTopThreeFastestLap(raceResult: RaceResult) {
        raceResult.results.forEach {
            it.fastestLap.lap
        }
    }


}
