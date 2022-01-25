package com.ryutec.masterdetailfood.dominio

import com.ryutec.masterdetailfood.data.Repository
import com.ryutec.masterdetailfood.data.model.CategoryList
import javax.inject.Inject

class GetPopularMealsUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke(): CategoryList {
        return repository.getPopularMeals()
    }

}