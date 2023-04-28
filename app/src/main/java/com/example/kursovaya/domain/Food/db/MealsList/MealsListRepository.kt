package com.example.kursovaya.domain.Food.db.MealsList

import androidx.lifecycle.LiveData


interface MealsListRepository {

    fun getBreakfastList(): LiveData<List<MealsItem>>

    suspend fun addBreakfastItem(mealsItem: MealsItem)

    fun getFullBreakfastFood(meal: String): LiveData<List<MealsWithFoodTuple>>

    suspend fun deleteMealsItem(id: Int)
}