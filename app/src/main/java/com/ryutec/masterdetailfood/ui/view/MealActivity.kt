package com.ryutec.masterdetailfood.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ryutec.masterdetailfood.databinding.ActivityMealBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}