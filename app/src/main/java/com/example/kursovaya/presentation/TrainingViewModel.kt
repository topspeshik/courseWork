package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.data.db.DayExerciseSettings.DayExerciseSettingsRepositoryImpl
import com.example.kursovaya.domain.db.DayExerciseSettings.*
import kotlinx.coroutines.launch


class TrainingViewModel(application: Application) : AndroidViewModel(application) {


    private val dayExerciseSettingsRepository = DayExerciseSettingsRepositoryImpl(application)
    private val getUniqueDaySettingsListUseCase: getUniqueDaySettingsListUseCase = getUniqueDaySettingsListUseCase(dayExerciseSettingsRepository)
    private val getCurrentDayUseCase: getCurrentDayUseCase = getCurrentDayUseCase(dayExerciseSettingsRepository)
    private val updateActiveToInactiveUseCase: updateActiveToInactiveUseCase = updateActiveToInactiveUseCase(dayExerciseSettingsRepository)
    private val updateInactiveToActiveUseCase: updateInactiveToActiveUseCase = updateInactiveToActiveUseCase(dayExerciseSettingsRepository)
    private val deleteDayItemUseCase = deleteDayItemUseCase(dayExerciseSettingsRepository)

    val daysList =  getUniqueDaySettingsListUseCase()

    val getCurrentDay = getCurrentDayUseCase()

    fun updateActiveToInactive(day_id: Int){
        viewModelScope.launch {
            updateActiveToInactiveUseCase(day_id)
        }
    }

    fun updateInactiveToActive(day_id: Int){
        viewModelScope.launch {
            updateInactiveToActiveUseCase(day_id)
        }
    }

    fun deleteDayItem(dayExerciseSettings: DayExerciseSettings){
        viewModelScope.launch {
            deleteDayItemUseCase(dayExerciseSettings.day_id)
        }
    }

}