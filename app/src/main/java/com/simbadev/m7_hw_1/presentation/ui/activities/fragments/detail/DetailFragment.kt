package com.simbadev.m7_hw_1.presentation.ui.activities.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.simbadev.m7_hw_1.R
import com.simbadev.m7_hw_1.base.BaseFragment
import com.simbadev.m7_hw_1.databinding.FragmentDetailBinding


class DetailFragment : BaseFragment() {
private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

   
}