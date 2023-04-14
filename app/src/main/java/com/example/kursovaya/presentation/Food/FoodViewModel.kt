package com.example.kursovaya.presentation.Food

import androidx.lifecycle.ViewModel
import com.example.kursovaya.domain.Food.db.BreakfastList.getFullBreakfastFoodUseCase

import javax.inject.Inject

class FoodViewModel @Inject constructor(
    private val getFullBreakfastFoodUseCase: getFullBreakfastFoodUseCase
): ViewModel() {


    fun getMealBJU(meal: String) = getFullBreakfastFoodUseCase(meal)


}
