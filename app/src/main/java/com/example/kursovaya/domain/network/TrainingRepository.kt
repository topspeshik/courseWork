package com.example.kursovaya.domain.network



interface TrainingRepository {

    suspend fun getTrainingList() : List<Training>

    suspend fun getUpdateInfo() : UpdateDate

}