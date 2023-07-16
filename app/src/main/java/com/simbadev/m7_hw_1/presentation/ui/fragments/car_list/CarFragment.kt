package com.simbadev.m7_hw_1.presentation.ui.fragments.car_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.simbadev.m7_hw_1.R
import com.simbadev.m7_hw_1.presentation.utils.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CarFragment : Fragment() {

    private val viewModel by viewModels<CarViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllCars()


        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAllCarsState.collect {
                when (it) {
                    is UiState.EmptyState -> {
                        Toast.makeText(requireContext(), "Empty state", Toast.LENGTH_SHORT).show()
                    }

                    is UiState.Error -> {
                        Toast.makeText(requireContext(), "Error ${it}", Toast.LENGTH_SHORT).show()

                    }

                    is UiState.Loading -> {
                        // loadingProgressBar = true
                    }

                    is UiState.Success -> {
                        // loadingProgressBar = false
                        // add list to adapter
                    }
                }
            }
        }
    }

}