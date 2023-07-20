package com.simbadev.m7_hw_1.presentation.utils

sealed class UiState<T> {
    class Loading<T> : UiState<T>()
    class Success<T>(val data : T) : UiState<T>()
    class Error<T>(message: String?): UiState<T>()
    class EmptyState<T> : UiState<T>()

}