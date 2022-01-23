package com.ryutec.masterdetailfood.dominio

import com.ryutec.masterdetailfood.data.Repository
import com.ryutec.masterdetailfood.data.model.Meal
import com.ryutec.masterdetailfood.data.model.MealList
import com.ryutec.masterdetailfood.data.network.MealService
import javax.inject.Inject

class GetMealUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke(url:String): MealList {
        return repository.getAllMeals(url)
    }
}