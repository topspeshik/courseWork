package com.example.kursovaya.domain.Food.db.MealsList

import javax.inject.Inject

class deleteMealsItemUseCase @Inject constructor(
    private val repository: MealsListRepository
) {
    suspend operator fun invoke(id: Int) = repository.deleteMealsItem(id)
}