package com.example.kursovaya.data.db.DayExerciseSettings

import com.example.kursovaya.data.db.ExerciseList.ExerciseListMapper
import com.example.kursovaya.data.db.NetworkList.NetworkListMapper
import com.example.kursovaya.data.db.models.DayExerciseSettingsDbModel
import com.example.kursovaya.data.db.models.ExerciseWithNetworkTupleDbModel
import com.example.kursovaya.domain.db.DayExerciseSettings.DayExerciseSettings
import com.example.kursovaya.domain.db.DayExerciseSettings.ExerciseWithNetworkTuple
import javax.inject.Inject

class DayExerciseSettingsMapper @Inject constructor(){

    private val mapperExercise = ExerciseListMapper()
    private val mapperNetwork = NetworkListMapper()

    private fun mapDayExerciseSettingsDbToEntity(dayExerciseSettingsDbModel: DayExerciseSettingsDbModel) = DayExerciseSettings(
        day_id = dayExerciseSettingsDbModel.day_id,
        exercise_id = dayExerciseSettingsDbModel.exercise_id,
        active = dayExerciseSettingsDbModel.active,
        dayExercise_id = dayExerciseSettingsDbModel.dayExercise_id
    )

    fun mapEntityToDayExerciseSettingsDb(dayExerciseSettings: DayExerciseSettings) = DayExerciseSettingsDbModel(
        day_id = dayExerciseSettings.day_id,
        exercise_id = dayExerciseSettings.exercise_id,
        active = dayExerciseSettings.active
    )

    fun mapTupleDbToEntity(exerciseWithNetworkTupleDbModel: ExerciseWithNetworkTupleDbModel) = ExerciseWithNetworkTuple(
        exercise =  mapperExercise.mapExerciseDbToEntity(exerciseWithNetworkTupleDbModel.exercise),
        network = mapperNetwork.mapNetworkDbToEntity(exerciseWithNetworkTupleDbModel.network)

    )

    fun mapListTupleDbToEntity(list: List<ExerciseWithNetworkTupleDbModel>) = list.map{
        mapTupleDbToEntity(it)
    }

    fun mapListDayExercisesDbToListEntity(list: List<DayExerciseSettingsDbModel>) = list.map{
        mapDayExerciseSettingsDbToEntity(it)
    }

}