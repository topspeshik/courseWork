package com.example.kursovaya.domain.Food.network

import com.example.kursovaya.domain.Training.network.UpdateDate


interface FoodRepository {

    suspend fun getFoodList() : List<Food>

    suspend fun getUpdateInfo() : UpdateDate

}