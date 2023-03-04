package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.data.db.ExerciseDatabase
import com.example.kursovaya.data.db.ExerciseItemDbModel
import kotlinx.coroutines.launch


class AddExerciseViewModel(application: Application) : AndroidViewModel(application) {


    private val exerciseDatabase = ExerciseDatabase.getInstance(getApplication())

    fun addExerciseItem(day_id: Int, ex_name: String, sets: String, reps: String, kg: String) {
        viewModelScope.launch {
            exerciseDatabase.exerciseListDao().addExerciseItem(
                ExerciseItemDbModel(
                    day_id,
                    ex_name,
                    sets,
                    reps,
                    kg
                )
            )
        }
    }
}