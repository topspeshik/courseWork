package com.example.kursovaya.data.db

import com.example.kursovaya.domain.ExerciseItem

class ExerciseListMapper {

    fun mapEntityToDbModel(exerciseItem: ExerciseItem) = ExerciseItemDbModel(
        day_id = exerciseItem.day_id,
        exercise_name = exerciseItem.exercise_name,
        sets = exerciseItem.sets,
        reps = exerciseItem.reps,
        kg = exerciseItem.kg,
        urlimg = exerciseItem.urlimg,
        urlgif = exerciseItem.urlgif
    )

}