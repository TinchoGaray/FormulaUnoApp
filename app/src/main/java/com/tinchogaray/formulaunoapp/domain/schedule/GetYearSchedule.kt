package com.tinchogaray.formulaunoapp.domain.schedule

import com.tinchogaray.formulaunoapp.data.ScheduleRepository
import com.tinchogaray.formulaunoapp.domain.model.RaceSchedule
import javax.inject.Inject

class GetYearSchedule @Inject constructor(private val repository: ScheduleRepository) {

    suspend operator fun invoke(year: String): List<RaceSchedule> {
        return repository.getYearSchedulesFromApi(year)
    }
}
