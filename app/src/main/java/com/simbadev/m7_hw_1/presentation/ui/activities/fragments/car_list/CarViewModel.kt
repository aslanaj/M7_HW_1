package com.simbadev.m7_hw_1.presentation.ui.activities.fragments.car_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simbadev.M7_HW_1.domain.models.Car
import com.simbadev.M7_HW_1.domain.usecases.AddCarUseCase
import com.simbadev.m7_hw_1.base.BaseViewModel
import com.simbadev.m7_hw_1.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor(private val getCarUseCase: com.simbadev.M7_HW_1.domain.usecases.GetCarUseCase,
private val addCarUseCase: AddCarUseCase) : BaseViewModel() {

    private val _getAllCarsState = MutableStateFlow<UiState<List<Car>>>(UiState.EmptyState())

    val getAllCarsState = this._getAllCarsState.asStateFlow()

    suspend fun addCars(car: Car){
        addCarUseCase.execute(car = car)
    }

    fun getAllCars() {
        getCarUseCase.getAllCars().collectData(_getAllCarsState)
    }
}