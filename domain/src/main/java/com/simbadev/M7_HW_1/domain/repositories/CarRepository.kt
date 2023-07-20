package com.simbadev.M7_HW_1.domain.repositories

import com.simbadev.M7_HW_1.domain.models.Car
import com.simbadev.M7_HW_1.domain.utils.Resource

import kotlinx.coroutines.flow.Flow

interface CarRepository {

    suspend fun addCar(car: Car)

    fun getCar(): Flow<Resource<List<Car>>>

    fun getCarYear():Flow<Resource<List<Car>>>

   fun getCarMaxSpeed():Flow<Resource<List<Car>>>

   suspend fun updateCar(car: Car)

    suspend fun deleteCar(car: Car)
}