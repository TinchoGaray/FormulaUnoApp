package com.tinchogaray.formulaunoapp.di

import com.tinchogaray.formulaunoapp.data.network.driver.DriversApiClient
import com.tinchogaray.formulaunoapp.data.network.result.ResultApiClient
import com.tinchogaray.formulaunoapp.data.network.schedule.ScheduleApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ergast.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDriversApiClient(retrofit: Retrofit): DriversApiClient {
        return retrofit.create(DriversApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideScheduleApiClient(retrofit: Retrofit): ScheduleApiClient {
        return retrofit.create(ScheduleApiClient::class.java)
    }

    @Singleton
    @Provides
    fun providesResultApiClient(retrofit: Retrofit): ResultApiClient {
        return retrofit.create(ResultApiClient::class.java)
    }

}