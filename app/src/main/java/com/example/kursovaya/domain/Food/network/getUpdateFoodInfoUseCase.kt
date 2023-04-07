package com.example.kursovaya.domain.Food.network

import javax.inject.Inject


class getUpdateFoodInfoUseCase  @Inject constructor(
    private val repository: FoodRepository
) {
    suspend operator fun invoke() = repository.getUpdateInfo()
}