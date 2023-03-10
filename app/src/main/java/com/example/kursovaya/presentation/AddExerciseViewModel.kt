package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.data.db.ExerciseDatabase
import com.example.kursovaya.data.db.ExerciseItemDbModel
import kotlinx.coroutines.launch


class AddExerciseViewModel(application: Application) : AndroidViewModel(application) {


    private val exerciseDatabase = ExerciseDatabase.getInstance(getApplication())
    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    fun addExerciseItem(day_id: Int, ex_name: String, inputSets: String, inputReps: String, inputKg: String, urlimg: String, urlgif: String) {
        val sets = parseCount(inputSets)
        val reps = parseCount(inputReps)
        val kg = parseCount(inputKg)
        if (validateInput(sets,reps,kg)) {
            viewModelScope.launch {
                exerciseDatabase.exerciseListDao().addExerciseItem(
                    ExerciseItemDbModel(
                        day_id,
                        ex_name,
                        sets,
                        reps,
                        kg,
                        urlimg,
                        urlgif
                    )
                )
            }
        }
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(inputSets: Int, inputReps: Int, inputKg: Int): Boolean {
        if (inputSets <= 0 || inputReps<= 0  || inputKg<= 0 ) {
            _errorInputCount.value = true
            return false
        }
        return true
    }

}