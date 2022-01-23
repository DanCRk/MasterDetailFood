package com.ryutec.masterdetailfood.dominio

import com.ryutec.masterdetailfood.data.Repository
import com.ryutec.masterdetailfood.data.model.Meal
import javax.inject.Inject

class GetRandomMealUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke(): Meal {
        return repository.getAllMeals("random.php").meals[0]
    }
}