package com.example.kursovaya.domain.Training.db.DayExerciseSettings

import javax.inject.Inject

class getExerciseListPerDayUseCase @Inject constructor (
    private val repository: DayExerciseSettingsRepository
) {
    operator fun invoke(id: Int) = repository.getExerciseListPerDay(id)
}