package com.tinchogaray.formulaunoapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ergast.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
