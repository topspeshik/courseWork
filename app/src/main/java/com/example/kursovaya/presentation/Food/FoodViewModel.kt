package com.example.kursovaya.presentation.Food

import androidx.lifecycle.ViewModel
import com.example.kursovaya.domain.Food.db.MealsList.getFullMealsFoodUseCase

import javax.inject.Inject

class FoodViewModel @Inject constructor(
    private val getFullMealsFoodUseCase: getFullMealsFoodUseCase
): ViewModel() {


    fun getMealBJU(meal: String) = getFullMealsFoodUseCase(meal)


}
