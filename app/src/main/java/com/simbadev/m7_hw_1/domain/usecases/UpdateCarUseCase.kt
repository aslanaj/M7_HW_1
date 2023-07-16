package com.simbadev.m7_hw_1.domain.usecases

import com.simbadev.m7_hw_1.domain.models.Car
import com.simbadev.m7_hw_1.domain.repositories.CarRepository
import javax.inject.Inject

class UpdateCarUseCase @Inject constructor(
    private val carRepository: CarRepository
) {
    fun execute(car: Car){
        carRepository.updateCar(car = car)
    }
}