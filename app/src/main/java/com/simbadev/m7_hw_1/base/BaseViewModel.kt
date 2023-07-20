package com.simbadev.m7_hw_1.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simbadev.M7_HW_1.domain.utils.Resource
import com.simbadev.m7_hw_1.presentation.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel()
{

    protected fun <T> Flow<Resource<T>>.collectData(
        _state: MutableStateFlow<UiState<T>>
    ) {
        viewModelScope.launch {
            this@collectData.collect() { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.value = UiState.Loading()
                    }

                    is Resource.Success -> {
                        if (resource.data != null) {
                            _state.value = UiState.Success(resource.data!!)
                        }
                    }

                    is Error -> {
                        _state.value = UiState.Error(resource.message ?: "Error")
                    }

                    else -> {

                    }
                }
            }
        }
    }

}