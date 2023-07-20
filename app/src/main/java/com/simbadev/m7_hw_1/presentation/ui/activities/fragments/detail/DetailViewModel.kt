package com.simbadev.m7_hw_1.presentation.ui.activities.fragments.detail

import android.view.View
import androidx.lifecycle.ViewModel
import com.simbadev.M7_HW_1.domain.models.Car
import com.simbadev.M7_HW_1.domain.usecases.DeleteCarUseCase
import com.simbadev.M7_HW_1.domain.usecases.UpdateCarUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateCarUseCase: UpdateCarUseCase,
    private val deleteCarUseCase: DeleteCarUseCase

) : ViewModel() {

    fun updateCar(car: Car){
        updateCarUseCase.execute(car = car)
    }

    fun deleteCar(car: Car){
        deleteCarUseCase.excute(car = car)
    }

}



