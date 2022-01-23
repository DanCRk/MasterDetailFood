package com.ryutec.masterdetailfood.dominio

import com.ryutec.masterdetailfood.data.Repository
import com.ryutec.masterdetailfood.data.model.Meal
import com.ryutec.masterdetailfood.data.model.MealList
import com.ryutec.masterdetailfood.data.network.MealService
import javax.inject.Inject

class GetRandomMealUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke(url:String): Meal {
        return repository.getAllMeals(url).meals[0]
    }
}