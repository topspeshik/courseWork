package com.example.kursovaya.domain.db.DayExerciseSettings

class getCurrentDayUseCase(
    private val repository: DayExerciseSettingsRepository
) {
    operator fun invoke() = repository.getCurrentDay()
}