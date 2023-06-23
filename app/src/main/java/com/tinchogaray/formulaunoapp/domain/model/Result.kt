package com.tinchogaray.formulaunoapp.domain.model

import com.tinchogaray.formulaunoapp.data.model.result.ResultModel

data class Result (
    val number: String,
    val position: String,
    val points: String,
    val driver: Driver,
    val constructor: Constructor,
    val grid: String,
    val laps: String,
    val status: String,
    val finalTime: ResultTime,
    val fastestLap: FastestLap
)

fun ResultModel.toDomain() = Result(number, position, points, driver.toDomain(), constructor.toDomain(), grid, laps, status, finalTime?.toDomain() ?: ResultTime("-", "-"), fastestLap.toDomain())
