package com.example.kursovaya.domain.Food.db.BreakfastList

import javax.inject.Inject

class addBreakfastItemUseCase @Inject constructor(
    private val repository: BreakfastListRepository
) {
    suspend operator fun invoke(breakfastItem: BreakfastItem) = repository.addBreakfastItem(breakfastItem)
}