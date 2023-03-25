package com.example.kursovaya.domain.db.ExerciseList

class addExerciseItemUseCase(
    private val repository: ExerciseListRepository
) {
    suspend operator fun invoke(exerciseItem: ExerciseItem) = repository.addExerciseItem(exerciseItem)
}