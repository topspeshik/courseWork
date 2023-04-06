package com.example.kursovaya.domain.Training.network

import javax.inject.Inject

class getTrainingListUseCase  @Inject constructor(
    private val repository: TrainingRepository
) {
    suspend operator fun invoke() = repository.getTrainingList()
}