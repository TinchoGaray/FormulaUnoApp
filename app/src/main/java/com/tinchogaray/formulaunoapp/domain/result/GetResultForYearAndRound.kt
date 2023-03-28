package com.tinchogaray.formulaunoapp.domain.result

import com.tinchogaray.formulaunoapp.data.ResultsRepository
import com.tinchogaray.formulaunoapp.domain.model.RaceResult
import javax.inject.Inject

class GetResultForYearAndRound @Inject constructor(private val repository: ResultsRepository) {

    suspend operator fun invoke(year: String, round: String): List<RaceResult> {
        return repository.getRaceResultFromApi(year, round)
    }
}
