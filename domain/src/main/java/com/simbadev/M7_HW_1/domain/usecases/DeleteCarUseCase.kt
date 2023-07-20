package com.simbadev.M7_HW_1.domain.usecases

import com.simbadev.M7_HW_1.domain.models.Car
import javax.inject.Inject

class DeleteCarUseCase @Inject constructor(
    private val carRepository: com.simbadev.M7_HW_1.domain.repositories.CarRepository
) {


    suspend fun excute(car: Car){
        carRepository.deleteCar(car = car)
    }
}