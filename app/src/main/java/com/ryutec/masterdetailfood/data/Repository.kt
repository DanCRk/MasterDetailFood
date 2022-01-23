package com.ryutec.masterdetailfood.data

import com.ryutec.masterdetailfood.data.model.MealList
import com.ryutec.masterdetailfood.data.model.MealProvider
import com.ryutec.masterdetailfood.data.network.MealService
import javax.inject.Inject

class Repository @Inject constructor(private val api: MealService, private val provider:MealProvider) {

    suspend fun getAllMeals(url:String): MealList{
        val response = api.getMeal(url)
        provider.meals = response
        return response
    }
}