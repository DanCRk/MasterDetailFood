package com.ryutec.masterdetailfood.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.ryutec.masterdetailfood.data.model.Meal
import com.ryutec.masterdetailfood.databinding.FragmentHomeBinding
import com.ryutec.masterdetailfood.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class HomeFragment : Fragment(){

    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val mealViewModel:HomeViewModel by viewModels()
    private lateinit var randomMeal:Meal

    companion object{
        const val MEAL_ID = "com.ryutec.masterdetailfood.ui.view.idMeal"
        const val MEAL_NAME = "com.ryutec.masterdetailfood.ui.view.nameMeal"
        const val MEAL_THUMB = "com.ryutec.masterdetailfood.ui.view.thumbMeal"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mealViewModel.onCreate()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mealViewModel.randomMeal.observe(this, {
            Glide.with(this).load(it.strMealThumb).into(binding.imgRandomMeal)
            randomMeal = it
        })

        onRandomMealClick()

    }

    private fun onRandomMealClick() {
        binding.randomMeal.setOnClickListener {
            Toast.makeText(context,randomMeal.strMeal,Toast.LENGTH_LONG).show()
            val intent = Intent(this.context, MealActivity::class.java)
            intent.putExtra(MEAL_ID,randomMeal.idMeal)
                .putExtra(MEAL_NAME,randomMeal.strMeal)
                .putExtra(MEAL_THUMB,randomMeal.strMealThumb)
            startActivity(intent)
        }
    }


}