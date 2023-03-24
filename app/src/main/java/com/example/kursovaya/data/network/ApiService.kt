package com.example.kursovaya.data.network

import com.example.kursovaya.data.network.model.Training
import com.example.kursovaya.data.network.model.UpdateDate
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("training")
    suspend fun getTrainingList() : List<Training>

    @GET("update")
    suspend fun getUpdateInfo() : UpdateDate

}