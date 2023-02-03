package com.tinchogaray.formulaunoapp.data

import com.tinchogaray.formulaunoapp.data.network.schedule.ScheduleService
import com.tinchogaray.formulaunoapp.domain.model.RaceSchedule
import com.tinchogaray.formulaunoapp.domain.model.toDomain
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    private val api: ScheduleService
    ) {

    suspend fun getYearSchedulesFromApi(year: String): List<RaceSchedule> {
        val schedules = api.getYearSchedules(year)
        return schedules.map { it.toDomain() }
    }
}