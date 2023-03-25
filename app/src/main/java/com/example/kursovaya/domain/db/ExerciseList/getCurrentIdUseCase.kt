package com.example.kursovaya.domain.db.ExerciseList

class getCurrentIdUseCase(
    private val repository: ExerciseListRepository
) {
    suspend operator fun invoke() = repository.getCurrentId()
}