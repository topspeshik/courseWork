package com.example.kursovaya.data.network

import com.example.kursovaya.domain.network.Training
import com.example.kursovaya.domain.network.TrainingRepository
import com.example.kursovaya.domain.network.UpdateDate
import javax.inject.Inject

class TrainingRepositoryImpl @Inject constructor(
    private val apiFactory: ApiFactory,
    private val mapper: TrainingMapper
    ) : TrainingRepository {

    override suspend fun getTrainingList(): List<Training> {
        val trainingModel = apiFactory.apiService.getTrainingList()
        return mapper.mapTrainingListDtoToEntity(trainingModel)
    }

    override suspend fun getUpdateInfo(): UpdateDate {
        val updateModel = apiFactory.apiService.getUpdateInfo()
        return mapper.mapUpdateDtoToEntity(updateModel)
    }
}