package com.example.kursovaya.domain.Training.db.DayExerciseSettings

import javax.inject.Inject

class getUniqueDaySettingsListUseCase @Inject constructor(
    private val repository: DayExerciseSettingsRepository
) {
    operator fun invoke() = repository.getUniqueDaySettingsList()
}