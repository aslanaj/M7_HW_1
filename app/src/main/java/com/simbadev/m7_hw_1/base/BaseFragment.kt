package com.simbadev.m7_hw_1.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.simbadev.m7_hw_1.presentation.utils.UiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment : Fragment() {

    protected fun <T> StateFlow<UiState<T>>.collectState(
        loadingState: (UiState<T>) -> Unit,
        successState: (data: T?) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            this@collectState.collect() { result ->
                when (result) {
                    is UiState.EmptyState -> {}

                    is UiState.Error -> {
                        Toast.makeText(
                            requireContext(),
                            "Error ${result.toString()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    is UiState.Loading -> {
                        loadingState.invoke(UiState.Loading())
                    }

                    is UiState.Success -> {
                        successState.invoke(result.data)
                    }
                }
            }
        }
    }
}
