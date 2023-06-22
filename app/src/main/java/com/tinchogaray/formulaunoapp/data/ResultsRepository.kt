package com.tinchogaray.formulaunoapp.data

import com.tinchogaray.formulaunoapp.data.network.result.ResultService
import com.tinchogaray.formulaunoapp.domain.model.RaceResult
import com.tinchogaray.formulaunoapp.domain.model.toDomain
import javax.inject.Inject

class ResultsRepository @Inject constructor(private val serviceApi: ResultService ) {

    suspend fun getRaceResultFromApi(year: String, round: String): RaceResult {
        val results = serviceApi.getRaceResult(year, round)

        return results.toDomain()
    }
}
