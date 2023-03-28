package com.tinchogaray.formulaunoapp.domain.model

import com.tinchogaray.formulaunoapp.data.model.race.SpeedModel

data class Speed(
    val units: String,
    val speed: String
)

fun SpeedModel.toDomain() = Speed(units, speed)
