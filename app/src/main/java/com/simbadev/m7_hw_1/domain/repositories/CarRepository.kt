package com.simbadev.m7_hw_1.domain.repositories

import com.simbadev.m7_hw_1.domain.Resource
import com.simbadev.m7_hw_1.domain.models.Car
import kotlinx.coroutines.flow.Flow

interface CarRepository {

    fun addCar(car: Car) : Flow<Resource<Unit>>

    fun getCar(): Flow<Resource<List<Car>>>

    fun getCarYear():Flow<Resource<List<Car>>>

   fun getCarMaxSpeed():Flow<Resource<List<Car>>>

    fun updateCar(car: Car): Flow<Resource<Unit>>

    fun deleteCar(car: Car): Flow<Resource<Unit>>
}