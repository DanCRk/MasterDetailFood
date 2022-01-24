package com.ryutec.masterdetailfood.dominio

import com.ryutec.masterdetailfood.data.Repository
import com.ryutec.masterdetailfood.data.model.Meal
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke(id:String): Meal {
        return repository.getAllMeals("lookup.php?i=$id").meals[0]
    }
}