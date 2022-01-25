package com.ryutec.masterdetailfood.data.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ryutec.masterdetailfood.R
import com.ryutec.masterdetailfood.data.model.CategoryMeal

class RecyclerAdapter(val mealLIst:List<CategoryMeal>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.popular_meals, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(mealLIst[position])
    }

    override fun getItemCount(): Int = mealLIst.size

}