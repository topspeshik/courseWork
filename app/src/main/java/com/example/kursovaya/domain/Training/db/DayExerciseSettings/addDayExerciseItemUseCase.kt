package com.example.kursovaya.domain.Training.db.DayExerciseSettings

import javax.inject.Inject

class addDayExerciseItemUseCase @Inject constructor(
    private val repository: DayExerciseSettingsRepository
) {
    suspend operator fun invoke(dayExerciseSettings: DayExerciseSettings) = repository.addDayExerciseItem(dayExerciseSettings)
}