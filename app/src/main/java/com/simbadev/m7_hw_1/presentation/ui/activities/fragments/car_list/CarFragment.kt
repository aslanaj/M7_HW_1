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
import com.simbadev.m7_hw_1.databinding.FragmentCarBinding
import com.simbadev.m7_hw_1.presentation.utils.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CarFragment : Fragment() {

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
        viewModel.getAllCars()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAllCarsState.collect {
                when (it) {
                    is UiState.EmptyState -> {
                        Toast.makeText(requireContext(), "Empty state", Toast.LENGTH_SHORT).show()
                    }

                    is UiState.Error -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(requireContext(), "Error ${it}", Toast.LENGTH_SHORT).show()

                    }

                    is UiState.Loading -> {
                        binding.progressBar.isVisible = true
                    }

                    is UiState.Success -> {
                        binding.progressBar.isVisible = false
                        binding.rvCar.adapter = adapter
                        adapter.addTasks(it.data)
                        Toast.makeText(requireContext(), "Error ${it.data}", Toast.LENGTH_SHORT)
                    }
                }
            }
        }
    }

    private fun setOnClickListener() {
    binding.apply {
        btnSave.setOnClickListener {
            viewModel.addCars(
                Car(
                    id = (0..9999).random(),
                    name = etName.text.toString(),
                    year = etYear.text.toString() ,
                    maxSpeed = etMaxSpeed.text.toString()

                )
            )
            Toast.makeText(requireContext(), "item is add ${Car(
                id = (0..9999).random(),
                name = etName.text.toString(),
                year = etYear.text.toString(),
                maxSpeed = etMaxSpeed.text.toString()
            )}", Toast.LENGTH_SHORT).show()
        }
    }
    }

}