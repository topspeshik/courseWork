package com.example.kursovaya.domain.Food.db.MealsList

import javax.inject.Inject

class addMealsItemUseCase @Inject constructor(
    private val repository: MealsListRepository
) {
    suspend operator fun invoke(mealsItem: MealsItem) = repository.addBreakfastItem(mealsItem)
}