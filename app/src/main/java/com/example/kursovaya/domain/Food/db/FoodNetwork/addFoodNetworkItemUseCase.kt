package com.example.kursovaya.domain.Food.db.FoodNetwork

import javax.inject.Inject

class addFoodNetworkItemUseCase @Inject constructor(
    private val repository: FoodNetworkRepository
) {
    suspend operator fun invoke(foodItem: FoodItem) = repository.addNetworkItem(foodItem)
}