package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kursovaya.data.db.ExerciseDatabase



class TrainingViewModel(application: Application) : AndroidViewModel(application) {

    private val exerciseDatabase = ExerciseDatabase.getInstance(getApplication())
    val daysList =  exerciseDatabase.exerciseListDao().getDaysList()

}