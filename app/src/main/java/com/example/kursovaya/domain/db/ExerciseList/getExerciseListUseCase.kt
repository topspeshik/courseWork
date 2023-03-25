package com.example.kursovaya.domain.db.ExerciseList

import com.example.kursovaya.domain.network.TrainingRepository

class getExerciseListUseCase(
    private val repository: ExerciseListRepository
) {
    operator fun invoke() = repository.getExerciseList()
}