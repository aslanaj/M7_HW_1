package com.simbadev.m7_hw_1.domain.usecases

import com.simbadev.m7_hw_1.data.models.CarEntity
import com.simbadev.m7_hw_1.domain.Resource
import com.simbadev.m7_hw_1.domain.models.Car
import com.simbadev.m7_hw_1.domain.repositories.CarRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCarUseCase @Inject constructor(
    private val carRepository: CarRepository
) {

    fun execute(): Flow<Resource<List<Car>>> {
        return carRepository.getCar()
    }
}