package com.ryutec.masterdetailfood.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryutec.masterdetailfood.data.model.Meal
import com.ryutec.masterdetailfood.data.model.MealList
import com.ryutec.masterdetailfood.dominio.GetRandomMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MealViewModel @Inject constructor(
    private val getRandomMealUseCase: GetRandomMealUseCase
): ViewModel(){
    val randomMeal = MutableLiveData<Meal>()

    fun onCreate(){
        viewModelScope.launch {
            val result = getRandomMealUseCase("random.php")
            if (!result.idMeal.equals(null)){
                randomMeal.postValue(result)
            }
        }
    }
}