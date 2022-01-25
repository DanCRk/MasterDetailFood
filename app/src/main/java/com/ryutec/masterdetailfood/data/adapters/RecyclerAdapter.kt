package com.ryutec.masterdetailfood.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ryutec.masterdetailfood.R
import com.ryutec.masterdetailfood.data.model.CategoryMeal

class RecyclerAdapter(private val mealLIst:List<CategoryMeal>, private val onClickListener:(CategoryMeal) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.popular_meals, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(mealLIst[position], onClickListener)
    }

    override fun getItemCount(): Int = mealLIst.size

}