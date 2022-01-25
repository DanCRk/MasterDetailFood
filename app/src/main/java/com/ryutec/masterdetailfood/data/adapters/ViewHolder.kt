package com.ryutec.masterdetailfood.data.adapters

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ryutec.masterdetailfood.data.model.CategoryMeal
import com.ryutec.masterdetailfood.databinding.PopularMealsBinding

class ViewHolder (val view: View):RecyclerView.ViewHolder(view){

    val binding = PopularMealsBinding.bind(view)

    fun bind(meal:CategoryMeal){
        Glide.with(view.context)
            .load(meal.strMealThumb)
            .into(binding.imgPopularMeal)

        view.setOnClickListener{
            Toast.makeText(view.context, meal.strMeal, Toast.LENGTH_LONG).show()
        }
    }
}