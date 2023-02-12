package com.tinchogaray.formulaunoapp.domain.model

import com.tinchogaray.formulaunoapp.data.model.race.CircuitModel
import com.tinchogaray.formulaunoapp.data.model.race.RaceScheduleModel
import com.tinchogaray.formulaunoapp.data.model.race.RaceDate

data class RaceSchedule(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    val circuit: CircuitModel,
    val date: String,
    val time: String,
    val firstPractice: RaceDate?,
    val secondPractice: RaceDate?,
    val thirdPractice: RaceDate?,
    val sprint: RaceDate?,
    val qualifying: RaceDate?
)

fun RaceScheduleModel.toDomain() = RaceSchedule(season, round, url, raceName, circuit, date, time, firstPractice, secondPractice, thirdPractice, sprint, qualifying)