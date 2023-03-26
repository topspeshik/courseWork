package com.example.kursovaya.data.db.ExerciseList

import com.example.kursovaya.data.db.models.ExerciseItemDbModel
import com.example.kursovaya.data.db.models.NetworkItemDbModel
import com.example.kursovaya.domain.db.ExerciseList.ExerciseItem
import com.example.kursovaya.domain.db.ExerciseList.ExerciseListRepository
import com.example.kursovaya.domain.db.NetworkList.NetworkItem
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