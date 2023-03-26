package com.example.kursovaya.domain.db.DayExerciseSettings

import javax.inject.Inject

class updateInactiveToActiveUseCase @Inject constructor(
    private val repository: DayExerciseSettingsRepository
) {
    suspend operator fun invoke(day_id : Int) = repository.updateInactiveToActive(day_id)
}