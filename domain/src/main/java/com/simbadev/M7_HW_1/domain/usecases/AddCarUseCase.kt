package com.simbadev.M7_HW_1.domain.usecases

import com.simbadev.M7_HW_1.domain.models.Car

import javax.inject.Inject

class AddCarUseCase @Inject constructor(
   private val carRepository: com.simbadev.M7_HW_1.domain.repositories.CarRepository
) {

    suspend fun execute(car: Car){
        carRepository.addCar(car = car)
    }
}