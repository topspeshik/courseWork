package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kursovaya.data.db.DayExerciseSettings.DayExerciseSettingsRepositoryImpl
import com.example.kursovaya.domain.db.DayExerciseSettings.getExerciseListPerDayUseCase

class StartTrainingViewModel(application: Application) : AndroidViewModel(application) {


    private val dayExerciseSettingsRepository = DayExerciseSettingsRepositoryImpl(application)
    private val getExerciseListPerDayUseCase: getExerciseListPerDayUseCase = getExerciseListPerDayUseCase(dayExerciseSettingsRepository)

    fun getExerciseList(day_id: Int) = getExerciseListPerDayUseCase(day_id)


}