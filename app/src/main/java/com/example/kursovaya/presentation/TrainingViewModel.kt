package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.data.db.AppDatabase
import kotlinx.coroutines.launch


class TrainingViewModel(application: Application) : AndroidViewModel(application) {

    private val appDatabase = AppDatabase.getInstance(getApplication())
    val daysList =  appDatabase.dayExerciseSettingsDao().getUniqueDaySettingsList()

    val getCurrentDay = appDatabase.dayExerciseSettingsDao().getCurrentDay()

    fun updateActiveToInactive(day_id: Int){
        viewModelScope.launch {
            appDatabase.dayExerciseSettingsDao().updateActiveToInactive(day_id)
        }
    }

    fun updateInactiveToActive(day_id: Int){
        viewModelScope.launch {
            appDatabase.dayExerciseSettingsDao().updateInactiveToActive(day_id)
        }
    }

}