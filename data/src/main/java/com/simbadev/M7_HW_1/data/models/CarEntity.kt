package com.simbadev.M7_HW_1.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class CarEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    @ColumnInfo(name = "car_year")
    val year: String,
    @ColumnInfo(name = "car_maxSpeed")
    val maxSpeed: String,

    ) {

}
