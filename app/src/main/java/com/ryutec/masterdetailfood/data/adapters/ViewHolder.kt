package com.ryutec.masterdetailfood.data.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ryutec.masterdetailfood.data.model.CategoryMeal
import com.ryutec.masterdetailfood.databinding.PopularMealsBinding

class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = PopularMealsBinding.bind(view)

    fun bind(meal: CategoryMeal, onClickListener: (CategoryMeal) -> Unit) {
        Glide.with(view.context)
            .load(meal.strMealThumb)
            .into(binding.imgPopularMeal)

        itemView.setOnClickListener {
            onClickListener(meal)
        }
    }
}