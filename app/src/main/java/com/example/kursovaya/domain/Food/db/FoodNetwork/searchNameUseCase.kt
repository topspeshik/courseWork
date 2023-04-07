package com.example.kursovaya.domain.Food.db.FoodNetwork

import javax.inject.Inject

class searchNameUseCase @Inject constructor(
    private val repository: FoodNetworkRepository
) {
    operator fun invoke(sym: String) = repository.searchName(sym)
}