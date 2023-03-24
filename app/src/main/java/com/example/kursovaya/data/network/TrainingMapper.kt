package com.example.kursovaya.data.network

import com.example.kursovaya.data.network.model.TrainingDto
import com.example.kursovaya.data.network.model.UpdateDateDto
import com.example.kursovaya.domain.network.Training
import com.example.kursovaya.domain.network.UpdateDate

class TrainingMapper {
    fun mapTrainingDtoToEntity(trainingDto: TrainingDto) = Training(
        id = trainingDto.id,
        name = trainingDto.name,
        urlgif = trainingDto.urlgif,
        urlimg = trainingDto.urlimg
    )

    fun mapUpdateDtoToEntity(updateDateDto: UpdateDateDto) = UpdateDate(
        date = updateDateDto.date
    )

    fun mapTrainingListDtoToEntity(list: List<TrainingDto>) = list.map{
        mapTrainingDtoToEntity(it)
    }

}