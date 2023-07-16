package com.simbadev.m7_hw_1.presentation.ui.fragments.car_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.simbadev.m7_hw_1.domain.models.Car
import com.simbadev.m7_hw_1.domain.usecases.GetCarUseCase
import com.simbadev.m7_hw_1.domain.utils.Resource
import com.simbadev.m7_hw_1.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor(private val getCarUseCase: GetCarUseCase) : ViewModel() {

    private val _getAllCarsState = MutableStateFlow<UiState<List<Car>>>(UiState.EmptyState())

    val getAllCarsState = this._getAllCarsState.asStateFlow()

    fun getAllCars() {
        viewModelScope.launch {
            getCarUseCase.getAllCars().collect {
                when (it) {
                    is Resource.Loading -> {
                        _getAllCarsState.value = UiState.Loading()
                    }

                    is Resource.Success -> {
                        _getAllCarsState.value = UiState.Success(it.data as List<Car>)
                    }

                    is Resource.Error -> {
                        _getAllCarsState.value = UiState.Error(it.message ?: "error")
                    }
                }
            }
        }
    }
}