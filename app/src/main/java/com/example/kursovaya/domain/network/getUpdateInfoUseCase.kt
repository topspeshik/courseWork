package com.example.kursovaya.domain.network

import javax.inject.Inject


class getUpdateInfoUseCase  @Inject constructor(
    private val repository: TrainingRepository
) {
    suspend operator fun invoke() = repository.getUpdateInfo()
}