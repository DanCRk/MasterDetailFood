package com.ryutec.masterdetailfood.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryutec.masterdetailfood.data.model.Meal
import com.ryutec.masterdetailfood.data.model.MealList
import com.ryutec.masterdetailfood.dominio.GetDetailsUseCase
import com.ryutec.masterdetailfood.dominio.GetRandomMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MealViewModel @Inject constructor(
    private val getDetailsUseCase:GetDetailsUseCase
): ViewModel(){
    val detailsMeal = MutableLiveData<Meal>()
    val isloaded = MutableLiveData<Int>()

    fun onCreate(id:String){
        viewModelScope.launch {
            isloaded.postValue(1)
            val result = getDetailsUseCase(id)
            if (!result.idMeal.equals(null)){
                detailsMeal.postValue(result)
                isloaded.postValue(0)
            }
        }
    }
}