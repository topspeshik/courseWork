package com.example.kursovaya.domain.db.DayExerciseSettings

import javax.inject.Inject

class getCurrentDayUseCase @Inject constructor(
    private val repository: DayExerciseSettingsRepository
) {
    operator fun invoke() = repository.getCurrentDay()
}