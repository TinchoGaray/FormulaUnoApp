package com.tinchogaray.formulaunoapp.data

import com.tinchogaray.formulaunoapp.data.network.schedule.ScheduleService
import com.tinchogaray.formulaunoapp.domain.model.Race
import com.tinchogaray.formulaunoapp.domain.model.toDomain
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    private val api: ScheduleService
    ) {

    suspend fun getYearSchedulesFromApi(year: String): List<Race> {
        val schedules = api.getYearSchedules(year)
        return schedules.map { it.toDomain() }
    }
}