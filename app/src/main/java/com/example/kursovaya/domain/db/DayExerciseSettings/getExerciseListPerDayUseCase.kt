package com.example.kursovaya.domain.db.DayExerciseSettings

class getExerciseListPerDayUseCase (
    private val repository: DayExerciseSettingsRepository
) {
    operator fun invoke(id: Int) = repository.getExerciseListPerDay(id)
}