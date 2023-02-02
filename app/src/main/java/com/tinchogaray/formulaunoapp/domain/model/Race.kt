package com.tinchogaray.formulaunoapp.domain.model

import com.tinchogaray.formulaunoapp.data.model.race.CircuitModel
import com.tinchogaray.formulaunoapp.data.model.race.RaceModel
import com.tinchogaray.formulaunoapp.data.model.race.RaceSchedule

data class Race(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    val circuit: CircuitModel,
    val date: String,
    val time: String,
    val firstPractice: RaceSchedule,
    val secondPractice: RaceSchedule,
    val thirdPractice: RaceSchedule,
    val qualifying: RaceSchedule
)

fun RaceModel.toDomain() = Race(season, round, url, raceName, circuit, date, time, firstPractice, secondPractice, thirdPractice, qualifying)