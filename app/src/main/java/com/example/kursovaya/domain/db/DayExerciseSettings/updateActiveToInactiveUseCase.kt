package com.example.kursovaya.domain.db.DayExerciseSettings

class updateActiveToInactiveUseCase (
    private val repository: DayExerciseSettingsRepository
) {
    suspend operator fun invoke(day_id : Int) = repository.updateActiveToInactive(day_id)
}