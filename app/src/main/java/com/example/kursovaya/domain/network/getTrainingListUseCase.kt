package com.example.kursovaya.domain.network

class getTrainingListUseCase(
    private val repository: TrainingRepository
) {
    suspend operator fun invoke() = repository.getTrainingList()
}