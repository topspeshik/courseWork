package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kursovaya.data.db.ExerciseItemDbModel

class TrainingProcessViewModelFactory(
    private val application: Application,
    private val exercises: Array<ExerciseItemDbModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrainingProcessViewModel::class.java))
            return TrainingProcessViewModel(application, exercises) as T
        throw RuntimeException("Unknown view model $modelClass")
    }
}