package com.simbadev.M7_HW_1.data.mappers

import com.simbadev.M7_HW_1.data.models.CarEntity
import com.simbadev.M7_HW_1.domain.models.Car




fun Car.toEntity() = CarEntity(id,name, year, maxSpeed)
fun CarEntity.toCar() = Car(id, name, year, maxSpeed)