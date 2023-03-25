package com.example.kursovaya.domain.db.DayExerciseSettings

class getUniqueDaySettingsListUseCase (
    private val repository: DayExerciseSettingsRepository
) {
    operator fun invoke() = repository.getUniqueDaySettingsList()
}