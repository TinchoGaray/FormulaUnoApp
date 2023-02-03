package com.tinchogaray.formulaunoapp.data.network.schedule

import com.tinchogaray.formulaunoapp.data.model.race.RaceScheduleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScheduleService @Inject constructor(private val api: ScheduleApiClient) {

    suspend fun getYearSchedules(year: String): List<RaceScheduleModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getYearSchedules(year)
            val body = response.body()
            body?.mrDataSchedules?.raceTable?.races ?: emptyList()
        }
    }
}