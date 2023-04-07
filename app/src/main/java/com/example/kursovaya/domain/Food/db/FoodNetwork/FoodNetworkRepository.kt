package com.example.kursovaya.domain.Food.db.FoodNetwork

import androidx.lifecycle.LiveData

interface FoodNetworkRepository {

    suspend fun addNetworkItem(foodItem: FoodItem)

    fun searchName(sym: String): LiveData<List<FoodItem>>
}