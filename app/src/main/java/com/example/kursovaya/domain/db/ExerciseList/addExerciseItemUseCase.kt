package com.example.kursovaya.domain.db.ExerciseList

import javax.inject.Inject

class addExerciseItemUseCase @Inject constructor(
    private val repository: ExerciseListRepository
) {
    suspend operator fun invoke(exerciseItem: ExerciseItem) = repository.addExerciseItem(exerciseItem)
}