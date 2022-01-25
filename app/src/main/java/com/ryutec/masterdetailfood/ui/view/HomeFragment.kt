package com.ryutec.masterdetailfood.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ryutec.masterdetailfood.data.adapters.RecyclerAdapter
import com.ryutec.masterdetailfood.data.model.CategoryMeal
import com.ryutec.masterdetailfood.data.model.Meal
import com.ryutec.masterdetailfood.databinding.FragmentHomeBinding
import com.ryutec.masterdetailfood.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val mealViewModel: HomeViewModel by viewModels()
    private lateinit var randomMeal: Meal
    private lateinit var adapter: RecyclerAdapter
    private val popularMealList = mutableListOf<CategoryMeal>()

    companion object {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        mealViewModel.onCreate()
        mealViewModel.getPopularMeal()
        mealViewModel.randomMeal.observe(this, {
            Glide.with(this).load(it.strMealThumb).into(binding.imgRandomMeal)
            randomMeal = it

        })
        mealViewModel.popularMeal.observe(this, {
            popularMealList.addAll(it)
            refreshRecycleView()
        })
        onRandomMealClick()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun refreshRecycleView() {
        if (!popularMealList.isNullOrEmpty()) {
            adapter.notifyDataSetChanged()
        } else {
            showError()
        }
    }

    private fun showError() {
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setRecyclerView() {
        adapter = RecyclerAdapter(popularMealList) { meal -> onItemSelected(meal) }
        binding.recViewMealsPopular.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recViewMealsPopular.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun onItemSelected(meal: CategoryMeal) {
        Toast.makeText(context, meal.strMeal, Toast.LENGTH_LONG).show()
        val intent = Intent(this.context, MealActivity::class.java)
        intent.putExtra(MEAL_ID, meal.idMeal)
            .putExtra(MEAL_NAME, meal.strMeal)
            .putExtra(MEAL_THUMB, meal.strMealThumb)
        startActivity(intent)
    }

    private fun onRandomMealClick() {
        binding.randomMeal.setOnClickListener {
            Toast.makeText(context, randomMeal.strMeal, Toast.LENGTH_LONG).show()
            val intent = Intent(this.context, MealActivity::class.java)
            intent.putExtra(MEAL_ID, randomMeal.idMeal)
                .putExtra(MEAL_NAME, randomMeal.strMeal)
                .putExtra(MEAL_THUMB, randomMeal.strMealThumb)
            startActivity(intent)
        }
    }


}