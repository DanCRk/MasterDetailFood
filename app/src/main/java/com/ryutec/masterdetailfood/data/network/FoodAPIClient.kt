package com.ryutec.masterdetailfood.data.network

import com.ryutec.masterdetailfood.data.model.CategoryList
import com.ryutec.masterdetailfood.data.model.MealList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface FoodAPIClient {
    @GET
    suspend fun getMeal(@Url url:String): Response<MealList>

    @GET("filter.php?c=Seafood")
    suspend fun getPopularMeal(): Response<CategoryList>
}