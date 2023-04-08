package com.example.kursovaya.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.domain.Food.db.BreakfastList.BreakfastItem
import com.example.kursovaya.domain.Food.db.BreakfastList.addBreakfastItemUseCase
import kotlinx.coroutines.launch

import javax.inject.Inject

class AddMealViewModel @Inject constructor(
    private val addBreakfastItemUseCase: addBreakfastItemUseCase
): ViewModel() {


    fun addBreakfastItem(name: String, weight: Int){
        viewModelScope.launch {
            addBreakfastItemUseCase(
                BreakfastItem(
                    name,
                    weight
                )
            )
        }
    }

}