package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kursovaya.data.db.ExerciseDatabase

class StartTrainingViewModel(application: Application) : AndroidViewModel(application) {

    private val exerciseDatabase = ExerciseDatabase.getInstance(getApplication())

    fun getExerciseList(day_id: Int) = exerciseDatabase.exerciseListDao().getExerciseListPerDay(day_id)


}