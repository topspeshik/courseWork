package com.example.kursovaya.domain.db.DayExerciseSettings

class updateInactiveToActiveUseCase (
    private val repository: DayExerciseSettingsRepository
) {
    suspend operator fun invoke(day_id : Int) = repository.updateInactiveToActive(day_id)
}