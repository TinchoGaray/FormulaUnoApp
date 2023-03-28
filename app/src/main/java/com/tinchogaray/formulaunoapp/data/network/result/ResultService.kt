package com.tinchogaray.formulaunoapp.data.network.result

import com.tinchogaray.formulaunoapp.data.model.result.RaceResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ResultService @Inject constructor(private val api: ResultApiClient) {

    suspend fun getRaceResult(year: String, round: String): List<RaceResultModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getRaceResult(year, round)
            val body = response.body()
            body?.mrDataResult?.raceTable?.races ?: emptyList()
        }
    }
}
