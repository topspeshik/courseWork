package com.example.kursovaya.domain.db.DayExerciseSettings

class deleteDayItemUseCase (
    private val repository: DayExerciseSettingsRepository
) {
    suspend operator fun invoke(day_id : Int) = repository.deleteDayItem(day_id)
}