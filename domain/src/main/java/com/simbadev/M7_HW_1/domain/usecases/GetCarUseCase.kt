package com.simbadev.M7_HW_1.domain.usecases

import com.simbadev.M7_HW_1.domain.repositories.CarRepository
import javax.inject.Inject

class GetCarUseCase @Inject constructor(
    private val carRepository: com.simbadev.M7_HW_1.domain.repositories.CarRepository
) {

    fun getAllCars() = carRepository.getCar()

}