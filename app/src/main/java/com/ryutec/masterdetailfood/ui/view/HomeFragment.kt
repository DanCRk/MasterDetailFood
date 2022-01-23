package com.ryutec.masterdetailfood.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.ryutec.masterdetailfood.R
import com.ryutec.masterdetailfood.data.network.FoodAPIClient
import com.ryutec.masterdetailfood.data.network.MealService
import com.ryutec.masterdetailfood.databinding.FragmentHomeBinding
import com.ryutec.masterdetailfood.ui.viewmodel.MealViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(){

    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val mealViewModel:MealViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }




}