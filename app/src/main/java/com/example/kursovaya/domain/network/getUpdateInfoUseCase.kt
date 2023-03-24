package com.example.kursovaya.domain.network


class getUpdateInfoUseCase(
    private val repository: TrainingRepository
) {
    suspend operator fun invoke() = repository.getUpdateInfo()
}