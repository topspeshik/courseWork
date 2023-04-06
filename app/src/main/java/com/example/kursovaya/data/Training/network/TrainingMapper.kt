package com.example.kursovaya.data.Training.network

import com.example.kursovaya.data.Training.network.model.TrainingDto
import com.example.kursovaya.data.Training.network.model.UpdateDateDto
import com.example.kursovaya.domain.Training.network.Training
import com.example.kursovaya.domain.Training.network.UpdateDate
import javax.inject.Inject

class TrainingMapper  @Inject constructor(){
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