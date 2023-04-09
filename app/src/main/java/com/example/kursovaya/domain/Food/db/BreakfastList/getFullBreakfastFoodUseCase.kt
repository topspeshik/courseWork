package com.example.kursovaya.domain.Food.db.BreakfastList

import javax.inject.Inject

class getFullBreakfastFoodUseCase @Inject constructor(
    private val repository: BreakfastListRepository
) {
    operator fun invoke(meal: String) = repository.getFullBreakfastFood(meal)
}