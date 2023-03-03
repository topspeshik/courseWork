package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kursovaya.data.db.ExerciseDatabase
import com.example.kursovaya.data.db.ExerciseItemDbModel



class AddExerciseViewModel(application: Application) : AndroidViewModel(application) {


    private val exerciseDatabase = ExerciseDatabase.getInstance(getApplication())

    fun addExerciseItem(day_id: Int, ex_id: Int, ex_name: String, sets: String, reps: String, kg: String) {
//        exerciseDatabase.shopListDao().addExerciseItemSync(ExerciseItemDbModel(
//            day_id,
//            ex_id,
//            ex_name,
//            sets,
//            reps,
//            kg
//        ))
    }
}