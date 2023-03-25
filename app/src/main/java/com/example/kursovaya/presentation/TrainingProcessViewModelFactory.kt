package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kursovaya.domain.db.DayExerciseSettings.ExerciseWithNetworkTuple

class TrainingProcessViewModelFactory(
    private val application: Application,
    private val exercises: Array<ExerciseWithNetworkTuple>,
    private val dayId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrainingProcessViewModel::class.java))
            return TrainingProcessViewModel(application, exercises, dayId) as T
        throw RuntimeException("Unknown view model $modelClass")
    }
}