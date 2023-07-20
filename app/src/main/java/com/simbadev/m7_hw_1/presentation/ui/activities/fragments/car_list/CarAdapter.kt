package com.simbadev.m7_hw_1.presentation.ui.activities.fragments.car_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.simbadev.M7_HW_1.domain.models.Car
import com.simbadev.m7_hw_1.databinding.ItemCarBinding

class CarAdapter : Adapter<CarAdapter.CarViewHolder>() {
    private val carList = arrayListOf<Car>()

    fun addTasks(car: List<Car>) {
        carList.addAll(car)
        carList.clear()
        notifyDataSetChanged()

    }


    inner class CarViewHolder(private val binding: ItemCarBinding) : ViewHolder(binding.root) {
        fun onBind(car: Car) {
            binding.apply {
                tvName.text = car.name
                tvYear.text = car.year.toString()
                tvMaxSpeed.text = car.maxSpeed.toString()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(
            ItemCarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.onBind(carList[position])
    }
}