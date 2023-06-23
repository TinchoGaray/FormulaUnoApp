package com.tinchogaray.formulaunoapp.domain.model

import com.tinchogaray.formulaunoapp.data.model.result.ResultTimeModel

data class ResultTime(
    val millis: String?,
    val time: String?
)

fun ResultTimeModel.toDomain() = ResultTime(millis, time)

