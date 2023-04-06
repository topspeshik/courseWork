package com.example.kursovaya.domain.Training.db.DayExerciseSettings

import androidx.lifecycle.LiveData

interface DayExerciseSettingsRepository {

    fun getCurrentDay(): LiveData<Int>

    fun getUniqueDaySettingsList(): LiveData<List<DayExerciseSettings>>

    fun getExerciseListPerDay(id: Int): LiveData<List<ExerciseWithNetworkTuple>>

    suspend fun addDayExerciseItem(dayExerciseSettings: DayExerciseSettings)

    suspend fun updateActiveToInactive(day_id: Int)

    suspend fun updateInactiveToActive(day_id: Int)

    suspend fun deleteDayItem(day_id: Int)

}