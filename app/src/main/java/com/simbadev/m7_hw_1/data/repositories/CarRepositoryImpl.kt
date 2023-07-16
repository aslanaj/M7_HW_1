package com.simbadev.m7_hw_1.data.repositories

import com.simbadev.m7_hw_1.data.local.CarDao
import com.simbadev.m7_hw_1.data.mappers.toCar
import com.simbadev.m7_hw_1.data.mappers.toEntity
import com.simbadev.m7_hw_1.domain.Resource
import com.simbadev.m7_hw_1.domain.models.Car
import com.simbadev.m7_hw_1.domain.repositories.CarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val carDao: CarDao
) : CarRepository {


    override fun addCar(car: Car): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = carDao.addCar(car.toEntity()
                )
                emit(Resource.Success(data))
            }catch (e : Exception){
                emit(
                    Resource.Error(
                        // можно заменить  на элвис ?: -> e.localizedMessage ?: "unknown error"
                        if (e.localizedMessage != null){
                            e.localizedMessage
                        }else{
                            "unknown error"
                        }
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
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

    override fun updateCar(car: Car): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = carDao.updateCar(car.toEntity()
                )
                emit(Resource.Success(data))
            }catch (e : Exception){
                emit(
                    Resource.Error(
                        e.localizedMessage ?: "unknown error"
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun deleteCar(car: Car): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = carDao.deleteCar(car.toEntity()
                )
                emit(Resource.Success(data))
            }catch (e : Exception){
                emit(
                    Resource.Error(
                        e.localizedMessage ?: "unknown error"
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
    }


}