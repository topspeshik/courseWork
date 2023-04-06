package com.example.kursovaya.presentation.Training.StartTrainingAdapter

import androidx.lifecycle.ViewModel
import com.example.kursovaya.domain.Training.db.DayExerciseSettings.getExerciseListPerDayUseCase
import javax.inject.Inject

class StartTrainingViewModel @Inject constructor(
    private val getExerciseListPerDayUseCase: getExerciseListPerDayUseCase
) : ViewModel() {


//    private val dayExerciseSettingsRepository = DayExerciseSettingsRepositoryImpl(application)
//    private val getExerciseListPerDayUseCase: getExerciseListPerDayUseCase = getExerciseListPerDayUseCase(dayExerciseSettingsRepository)

    fun getExerciseList(day_id: Int) = getExerciseListPerDayUseCase(day_id)


}