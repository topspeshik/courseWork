package com.example.kursovaya.presentation.Food

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.domain.Food.db.MealsList.deleteMealsItemUseCase
import com.example.kursovaya.domain.Food.db.MealsList.getFullMealsFoodUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import javax.inject.Inject

class FoodViewModel @Inject constructor(
    private val getFullMealsFoodUseCase: getFullMealsFoodUseCase,
    private val deleteMealsItemUseCase: deleteMealsItemUseCase
): ViewModel() {


    fun getMealBJU(meal: String) = getFullMealsFoodUseCase(meal)

    fun deleteMealsItem(id: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                deleteMealsItemUseCase(id)
            }
        }
    }



}
