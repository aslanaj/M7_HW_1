package com.simbadev.m7_hw_1.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.simbadev.m7_hw_1.data.models.CarEntity

@Dao
interface CarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCar(carEntity: CarEntity)

    @Query("SELECT * FROM cars")
    suspend fun getCar(): List<CarEntity>

    @Query("SELECT * FROM cars car_year ")
    suspend fun getCarYear(): List<CarEntity>

    @Query("SELECT * FROM cars car_maxSpeed")
    suspend fun getCarMaxSpeed(): List<CarEntity>

    @Update
    suspend fun updateCar(carEntity: CarEntity)

    @Delete
    suspend fun deleteCar(carEntity: CarEntity)
}