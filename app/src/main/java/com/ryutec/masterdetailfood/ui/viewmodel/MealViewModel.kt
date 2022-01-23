package com.ryutec.masterdetailfood.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryutec.masterdetailfood.data.model.MealList
import com.ryutec.masterdetailfood.dominio.GetMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MealViewModel @Inject constructor(
    private val getMealUseCase: GetMealUseCase
): ViewModel(){
    val randomMeal = MutableLiveData<MealList>()

    fun onCreate(){
        viewModelScope.launch {
            val result = getMealUseCase("/random.php")
            if (!result.meals.isNullOrEmpty()){
                randomMeal.postValue(result)
            }
        }
    }
}