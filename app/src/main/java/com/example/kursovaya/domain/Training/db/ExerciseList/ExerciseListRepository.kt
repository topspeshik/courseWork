package com.example.kursovaya.domain.Training.db.ExerciseList

import androidx.lifecycle.LiveData

interface ExerciseListRepository {

    fun getExerciseList(): LiveData<List<ExerciseItem>>

    suspend fun getCurrentId(): Int

    suspend fun addExerciseItem(exerciseItem: ExerciseItem)
}