package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.data.db.ExerciseDatabase
import com.example.kursovaya.data.db.ExerciseItemDbModel
import kotlinx.coroutines.launch


class TrainingViewModel(application: Application) : AndroidViewModel(application) {

    private val exerciseDatabase = ExerciseDatabase.getInstance(getApplication())
    val daysList =  exerciseDatabase.exerciseListDao().getDaysList()

}