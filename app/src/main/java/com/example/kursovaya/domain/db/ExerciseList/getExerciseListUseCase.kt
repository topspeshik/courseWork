package com.example.kursovaya.domain.db.ExerciseList

import com.example.kursovaya.domain.network.TrainingRepository
import javax.inject.Inject

class getExerciseListUseCase @Inject constructor(
    private val repository: ExerciseListRepository
) {
    operator fun invoke() = repository.getExerciseList()
}