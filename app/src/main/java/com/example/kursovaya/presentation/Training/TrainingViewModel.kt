package com.example.kursovaya.presentation.Training

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.domain.Training.db.DayExerciseSettings.*

import kotlinx.coroutines.launch
import javax.inject.Inject


class TrainingViewModel  @Inject constructor(
    getUniqueDaySettingsListUseCase: getUniqueDaySettingsListUseCase,
    getCurrentDayUseCase: getCurrentDayUseCase,
    private val updateActiveToInactiveUseCase: updateActiveToInactiveUseCase,
    private val updateInactiveToActiveUseCase: updateInactiveToActiveUseCase,
    private val deleteDayItemUseCase : deleteDayItemUseCase
) : ViewModel() {


//    private val dayExerciseSettingsRepository = DayExerciseSettingsRepositoryImpl(application)
//    private val getUniqueDaySettingsListUseCase: getUniqueDaySettingsListUseCase = getUniqueDaySettingsListUseCase(dayExerciseSettingsRepository)
//    private val getCurrentDayUseCase: getCurrentDayUseCase = getCurrentDayUseCase(dayExerciseSettingsRepository)
//    private val updateActiveToInactiveUseCase: updateActiveToInactiveUseCase = updateActiveToInactiveUseCase(dayExerciseSettingsRepository)
//    private val updateInactiveToActiveUseCase: updateInactiveToActiveUseCase = updateInactiveToActiveUseCase(dayExerciseSettingsRepository)
//    private val deleteDayItemUseCase = deleteDayItemUseCase(dayExerciseSettingsRepository)

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