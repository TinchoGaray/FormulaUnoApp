package com.tinchogaray.formulaunoapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinchogaray.formulaunoapp.data.database.entity.DriverEntity

@Dao
interface DriverDao {

    @Query("SELECT * FROM driver_table ORDER BY permanentNumber DESC")
    suspend fun getAllDrivers(): List<DriverEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(drivers: List<DriverEntity>)

    @Query("DELETE FROM driver_table")
    suspend fun removeAllDrivers()
}