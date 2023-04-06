package com.example.kursovaya.domain.Training.network



interface TrainingRepository {

    suspend fun getTrainingList() : List<Training>

    suspend fun getUpdateInfo() : UpdateDate

}