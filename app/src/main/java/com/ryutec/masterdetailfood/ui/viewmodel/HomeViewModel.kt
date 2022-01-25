package com.ryutec.masterdetailfood.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryutec.masterdetailfood.data.model.CategoryMeal
import com.ryutec.masterdetailfood.data.model.Meal
import com.ryutec.masterdetailfood.dominio.GetPopularMealsUseCase
import com.ryutec.masterdetailfood.dominio.GetRandomMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomMealUseCase: GetRandomMealUseCase,
    private val getPopularMeals: GetPopularMealsUseCase
): ViewModel(){
    val randomMeal = MutableLiveData<Meal>()
    val popularMeal = MutableLiveData<List<CategoryMeal>>()

    fun onCreate(){
        viewModelScope.launch {
            val result = getRandomMealUseCase()
            if (!result.idMeal.equals(null)){
                randomMeal.postValue(result)
            }
        }
    }

    fun getPopularMeal(){
        viewModelScope.launch {
            val result = getPopularMeals().meals
            if (!result.isNullOrEmpty()){
                popularMeal.postValue(result)
            }
        }
    }
}