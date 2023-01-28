package com.tinchogaray.formulaunoapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tinchogaray.formulaunoapp.domain.model.Driver

@Entity(tableName = "driver_table")
data class DriverEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "driverId") val driverId: String,
    @ColumnInfo(name = "permanentNumber") val permanentNumber: String,
    @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "dateOfBirth") val dateOfBirth: String,
    @ColumnInfo(name = "nationality") val nationality: String
    )

fun Driver.toDatabase() = DriverEntity(
    driverId = driverId, permanentNumber = number, code = code, url = url, name = name,
    lastName = lastName, dateOfBirth = dateOfBirth, nationality = nationality
)