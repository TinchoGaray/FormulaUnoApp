package com.tinchogaray.formulaunoapp.di

import android.content.Context
import androidx.room.Room
import com.tinchogaray.formulaunoapp.data.database.DriverDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DRIVER_DATABASE_NAME = "f1_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, DriverDatabase::class.java, DRIVER_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDriverDao(db: DriverDatabase) = db.getDriverDao()
}