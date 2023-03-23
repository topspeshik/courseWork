package com.example.kursovaya.data.network

import com.example.kursovaya.data.network.model.Training
import retrofit2.http.GET

interface ApiService {

    @GET("training")
    suspend fun getTrainingList() : List<Training>

}