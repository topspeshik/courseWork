package com.example.kursovaya.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.domain.Food.db.BreakfastList.BreakfastItem
import com.example.kursovaya.domain.Food.db.BreakfastList.addBreakfastItemUseCase
import kotlinx.coroutines.launch

import javax.inject.Inject

class AddMealViewModel @Inject constructor(
    private val addBreakfastItemUseCase: addBreakfastItemUseCase
): ViewModel() {

    private val _shouldCloseScreen = MutableLiveData<Boolean>()
    val shouldCloseScreen: LiveData<Boolean>
        get() = _shouldCloseScreen

    fun addBreakfastItem(mealTime: String,name: String, weight: Int){
        viewModelScope.launch {
            addBreakfastItemUseCase(
                BreakfastItem(
                    mealTime,
                    name,
                    weight
                )
            )
        }

        _shouldCloseScreen.value = true
    }

}