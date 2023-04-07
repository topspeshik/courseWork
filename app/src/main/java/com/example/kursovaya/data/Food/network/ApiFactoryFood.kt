package com.example.kursovaya.data.Training.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactoryFood {

    private const val BASE_URL = "https://my-json-server.typicode.com/topspeshik/food/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(ApiServiceFood::class.java)

}