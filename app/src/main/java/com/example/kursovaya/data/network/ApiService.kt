package com.example.kursovaya.data.network

import com.example.kursovaya.data.network.model.TrainingDto
import com.example.kursovaya.data.network.model.UpdateDateDto
import retrofit2.http.GET

interface ApiService {

    @GET("training")
    suspend fun getTrainingList() : List<TrainingDto>

    @GET("update")
    suspend fun getUpdateInfo() : UpdateDateDto

}