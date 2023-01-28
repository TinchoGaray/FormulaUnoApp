package com.tinchogaray.formulaunoapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tinchogaray.formulaunoapp.data.database.dao.DriverDao
import com.tinchogaray.formulaunoapp.data.database.entity.DriverEntity

@Database(entities = [DriverEntity::class], version = 1, exportSchema = false)
abstract class DriverDatabase : RoomDatabase() {

    abstract fun getDriverDao(): DriverDao
}