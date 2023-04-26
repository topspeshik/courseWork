package com.example.kursovaya.data.Training.network

import com.example.kursovaya.data.Training.network.model.FoodDto
import com.example.kursovaya.data.Training.network.model.TrainingDto
import com.example.kursovaya.data.Training.network.model.UpdateDateDto
import com.example.kursovaya.data.Training.network.model.UpdateFoodDateDto
import retrofit2.http.GET

interface ApiServiceFood {
    @GET("food")
    suspend fun getFoodList() : List<FoodDto>

    @GET("update")
    suspend fun getUpdateInfo() : UpdateFoodDateDto
}