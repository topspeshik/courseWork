package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.kursovaya.data.db.DayExerciseSettings.DayExerciseSettingsRepositoryImpl
import com.example.kursovaya.domain.db.DayExerciseSettings.getExerciseListPerDayUseCase
import javax.inject.Inject

class StartTrainingViewModel @Inject constructor(
    private val getExerciseListPerDayUseCase: getExerciseListPerDayUseCase
) : ViewModel() {


//    private val dayExerciseSettingsRepository = DayExerciseSettingsRepositoryImpl(application)
//    private val getExerciseListPerDayUseCase: getExerciseListPerDayUseCase = getExerciseListPerDayUseCase(dayExerciseSettingsRepository)

    fun getExerciseList(day_id: Int) = getExerciseListPerDayUseCase(day_id)


}