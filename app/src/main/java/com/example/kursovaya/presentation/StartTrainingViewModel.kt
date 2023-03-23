package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kursovaya.data.db.AppDatabase

class StartTrainingViewModel(application: Application) : AndroidViewModel(application) {

    private val appDatabase = AppDatabase.getInstance(getApplication())

    fun getExerciseList(day_id: Int) = appDatabase.dayExerciseSettingsDao().getExerciseListPerDay(day_id)


}