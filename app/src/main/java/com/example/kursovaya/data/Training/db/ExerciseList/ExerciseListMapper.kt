package com.example.kursovaya.data.Training.db.ExerciseList

import com.example.kursovaya.data.Training.db.models.ExerciseItemDbModel
import com.example.kursovaya.domain.Training.db.ExerciseList.ExerciseItem
import javax.inject.Inject

class ExerciseListMapper @Inject constructor(){

    fun mapExerciseDbToEntity(exerciseItemDbModel: ExerciseItemDbModel) = ExerciseItem(
        name = exerciseItemDbModel.name,
        sets = exerciseItemDbModel.sets,
        reps = exerciseItemDbModel.reps,
        kg = exerciseItemDbModel.kg,
        id = exerciseItemDbModel.id
    )

    fun mapEntityToExerciseDb(exerciseItem: ExerciseItem) = ExerciseItemDbModel(
        name = exerciseItem.name,
        sets = exerciseItem.sets,
        reps = exerciseItem.reps,
        kg = exerciseItem.kg,
    )

    fun mapListExerciseDbToListEntity(list: List<ExerciseItemDbModel>) = list.map{
        mapExerciseDbToEntity(it)
    }



}