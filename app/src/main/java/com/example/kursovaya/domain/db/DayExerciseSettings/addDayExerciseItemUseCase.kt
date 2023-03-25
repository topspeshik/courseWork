package com.example.kursovaya.domain.db.DayExerciseSettings

class addDayExerciseItemUseCase (
    private val repository: DayExerciseSettingsRepository
) {
    suspend operator fun invoke(dayExerciseSettings: DayExerciseSettings) = repository.addDayExerciseItem(dayExerciseSettings)
}