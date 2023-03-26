package com.example.kursovaya.domain.db.ExerciseList

import javax.inject.Inject

class getCurrentIdUseCase @Inject constructor(
    private val repository: ExerciseListRepository
) {
    suspend operator fun invoke() = repository.getCurrentId()
}