package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kursovaya.data.db.AppDatabase



class TrainingViewModel(application: Application) : AndroidViewModel(application) {

    private val appDatabase = AppDatabase.getInstance(getApplication())
    val daysList =  appDatabase.dayExerciseSettingsDao().getDaysList()

    val getCurrentDay = appDatabase.dayExerciseSettingsDao().getCurrentDay()

}