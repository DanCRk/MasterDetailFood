package com.ryutec.masterdetailfood.data.network

import com.ryutec.masterdetailfood.data.model.MealList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MealService @Inject constructor( private val api:FoodAPIClient){

    suspend fun getMeal(url:String): MealList{
        return withContext(Dispatchers.IO){
            val response = api.getMeal(url)
            response.body()!!
        }
    }
}