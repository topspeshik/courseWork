package com.example.kursovaya.presentation.Food

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem
import com.example.kursovaya.domain.Food.db.FoodNetwork.searchNameUseCase
import com.example.kursovaya.domain.Food.db.MealsList.MealsItem
import com.example.kursovaya.domain.Food.db.MealsList.addMealsItemUseCase
import com.example.kursovaya.domain.Food.db.MealsList.deleteMealsItemUseCase
import kotlinx.coroutines.launch

import javax.inject.Inject

class AddMealViewModel @Inject constructor(
    private val addMealsItemUseCase: addMealsItemUseCase,
    private val deleteMealsItemUseCase: deleteMealsItemUseCase,
    private val searchNameUseCase: searchNameUseCase
): ViewModel() {

    private val _shouldCloseScreen = MutableLiveData<Boolean>()
    val shouldCloseScreen: LiveData<Boolean>
        get() = _shouldCloseScreen

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    fun addBreakfastItem(mealTime: String, name: String, inputWeight: String) {
        val weight = parseCount(inputWeight)
        if (validateInput(weight)) {
            viewModelScope.launch {
                addMealsItemUseCase(
                    MealsItem(
                        mealTime,
                        name,
                        weight
                    )
                )
            }

            _shouldCloseScreen.value = true
        }
    }

    fun deleteMealsitem(id: Int){
        viewModelScope.launch {
            deleteMealsItemUseCase(id)
        }

    }

    fun getFoodItem(name: String): LiveData<List<FoodItem>> = searchNameUseCase(name)



    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(inputWeight: Int): Boolean {
        if (inputWeight<= 0 ) {
            _errorInputCount.value = true
            return false
        }
        return true
    }

}


