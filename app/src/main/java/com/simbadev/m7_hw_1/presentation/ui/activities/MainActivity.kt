package com.simbadev.m7_hw_1.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.simbadev.m7_hw_1.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}