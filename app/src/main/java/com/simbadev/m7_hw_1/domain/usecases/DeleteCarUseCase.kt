package com.simbadev.m7_hw_1.domain.usecases

import com.simbadev.m7_hw_1.domain.models.Car
import com.simbadev.m7_hw_1.domain.repositories.CarRepository
import javax.inject.Inject

class DeleteCarUseCase @Inject constructor(
    private val carRepository: CarRepository
) {

    fun excute(car: Car) {
        carRepository.deleteCar(car = car)
    }
}