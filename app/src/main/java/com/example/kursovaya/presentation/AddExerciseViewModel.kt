package com.example.kursovaya.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.data.db.ExerciseDatabase
import com.example.kursovaya.data.db.ExerciseItemDbModel
import com.example.kursovaya.data.db.NetworkItemDbModel
import kotlinx.coroutines.launch


class AddExerciseViewModel(application: Application) : AndroidViewModel(application) {


    private val exerciseDatabase = ExerciseDatabase.getInstance(getApplication())
    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shouldCloseScreen = MutableLiveData<Boolean>()
    val shouldCloseScreen: LiveData<Boolean>
        get() = _shouldCloseScreen

    fun addExerciseItem(day_id: Int, ex_name: String, inputSets: String, inputReps: String, inputKg: String, urlimg: String, urlgif: String) {
        val sets = parseCount(inputSets)
        val reps = parseCount(inputReps)
        val kg = parseCount(inputKg)
        if (validateInput(sets,reps,kg)) {
            viewModelScope.launch {
                exerciseDatabase.networkListDao().addNetworkItem(
                    NetworkItemDbModel(
                        ex_name,
                        urlimg,
                        urlgif
                    )
                )
                exerciseDatabase.exerciseListDao().addExerciseItem(
                    ExerciseItemDbModel(
                        ex_name,
                        sets,
                        reps,
                        kg
                    )
                )

            }

            _shouldCloseScreen.value = true
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