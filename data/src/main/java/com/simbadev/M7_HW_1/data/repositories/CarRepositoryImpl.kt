package com.simbadev.M7_HW_1.data.repositories

import com.simbadev.M7_HW_1.data.local.CarDao
import com.simbadev.M7_HW_1.data.mappers.toCar
import com.simbadev.M7_HW_1.data.mappers.toEntity
import com.simbadev.M7_HW_1.domain.models.Car
import com.simbadev.M7_HW_1.domain.repositories.CarRepository
import com.simbadev.M7_HW_1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val carDao: CarDao
) : CarRepository {

    override suspend fun addCar(car: Car) {
      carDao.addCar(car.toEntity())
    }




    override fun getCar(): Flow<Resource<List<Car>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list = carDao.getCar()
                val data = list.map { it.toCar() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getCarYear(): Flow<Resource<List<Car>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list = carDao.getCarYear()
                val data = list.map { it.toCar() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getCarMaxSpeed(): Flow<Resource<List<Car>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list = carDao.getCarMaxSpeed()
                val data = list.map { it.toCar() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend  fun updateCar(car: Car){
       carDao.updateCar(car.toEntity())
    }

    override suspend fun deleteCar(car: Car) {
       carDao.deleteCar(car.toEntity())
    }
}