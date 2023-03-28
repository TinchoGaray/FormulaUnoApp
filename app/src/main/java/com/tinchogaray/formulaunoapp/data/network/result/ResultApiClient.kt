package com.tinchogaray.formulaunoapp.data.network.result

import com.tinchogaray.formulaunoapp.data.model.result.ResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ResultApiClient {

    @GET("api/f1/{year}/{round}/results.json")
    suspend fun getRaceResult(
        @Path("year") year: String,
        @Path("round") round: String
    ): Response<ResultResponse>
}