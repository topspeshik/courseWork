package com.example.kursovaya.domain.Food.db.BreakfastList

import androidx.lifecycle.LiveData


interface BreakfastListRepository {

    fun getBreakfastList(): LiveData<List<BreakfastItem>>

    suspend fun addBreakfastItem(breakfastItem: BreakfastItem)

    fun getFullBreakfastFood(meal: String): LiveData<List<BreakfastWithFoodTuple>>
}