package com.example.kursovaya.domain.Food.db.MealsList

import javax.inject.Inject

class getFullMealsFoodUseCase @Inject constructor(
    private val repository: MealsListRepository
) {
    operator fun invoke(meal: String) = repository.getFullBreakfastFood(meal)
}