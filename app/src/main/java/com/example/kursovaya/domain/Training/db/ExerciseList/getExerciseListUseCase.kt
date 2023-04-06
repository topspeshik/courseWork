package com.example.kursovaya.domain.Training.db.ExerciseList

import javax.inject.Inject

class getExerciseListUseCase @Inject constructor(
    private val repository: ExerciseListRepository
) {
    operator fun invoke() = repository.getExerciseList()
}