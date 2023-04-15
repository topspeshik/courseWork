package com.example.kursovaya.domain.Food.db.MealsList

import javax.inject.Inject

class getMealsListUseCase @Inject constructor(
    private val repository: MealsListRepository
) {
    operator fun invoke() = repository.getBreakfastList()
}