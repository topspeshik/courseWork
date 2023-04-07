package com.example.kursovaya.domain.Food.network

import javax.inject.Inject

class getFoodListUseCase  @Inject constructor(
    private val repository: FoodRepository
) {
    suspend operator fun invoke() = repository.getFoodList()
}