package com.example.kursovaya.data.Training.network

import com.example.kursovaya.domain.Training.network.Training
import com.example.kursovaya.domain.Training.network.TrainingRepository
import com.example.kursovaya.domain.Training.network.UpdateDate
import javax.inject.Inject

class TrainingRepositoryImpl @Inject constructor(
    private val apiFactory: ApiFactory,
    private val mapper: TrainingMapper
    ) : TrainingRepository {

    override suspend fun getTrainingList(): List<Training> {
        val trainingModel = ApiFactory.apiService.getTrainingList()
        return mapper.mapTrainingListDtoToEntity(trainingModel)
    }

    override suspend fun getUpdateInfo(): UpdateDate {
        val updateModel = ApiFactory.apiService.getUpdateInfo()
        return mapper.mapUpdateDtoToEntity(updateModel)
    }
}