package com.simbadev.m7_hw_1.presentation.ui.activities.fragments.car_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.simbadev.M7_HW_1.domain.models.Car
import com.simbadev.m7_hw_1.base.BaseFragment
import com.simbadev.m7_hw_1.databinding.FragmentCarBinding
import com.simbadev.m7_hw_1.presentation.utils.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CarFragment : BaseFragment() {

    private lateinit var binding: FragmentCarBinding
    private val viewModel by viewModels<CarViewModel>()
    private val adapter = CarAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickListener()
        viewModelClickListener()
    }

    private fun viewModelClickListener() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAllCarsState.collect { state ->
                when (state) {
                    is UiState.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    is UiState.Success -> {
                        binding.progressBar.isVisible = false
                        binding.rvCar.adapter = adapter
                    }

                    else -> {

                    }
                }
            }
        }
    }

    private fun setOnClickListener() {
        binding.btnSave.setOnClickListener {
            val newCar = Car(
                id = (0..9999).random(),
                name = binding.etName.text.toString(),
                year = binding.etYear.text.toString(),
                maxSpeed = binding.etMaxSpeed.text.toString()
            )
        }
    }
}
