package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.data.db.DayExerciseSettings.DayExerciseSettingsRepositoryImpl

import com.example.kursovaya.domain.db.DayExerciseSettings.ExerciseWithNetworkTuple
import com.example.kursovaya.domain.db.DayExerciseSettings.updateActiveToInactiveUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class TrainingProcessViewModel @Inject constructor(
    private val exercisesArgs: Array<ExerciseWithNetworkTuple>,
    private val dayId: Int,
    private val updateActiveToInactiveUseCase: updateActiveToInactiveUseCase
) : ViewModel(){

    private var count = 0
    private var countSets = 0


//    private val dayExerciseSettingsRepository = DayExerciseSettingsRepositoryImpl(application)
//    private val updateActiveToInactiveUseCase: updateActiveToInactiveUseCase = updateActiveToInactiveUseCase(dayExerciseSettingsRepository)


    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int>
        get() = _progress

    private val _progressText = MutableLiveData<String>()
    val progressText: LiveData<String>
        get() = _progressText

    private val _exercise = MutableLiveData<ExerciseWithNetworkTuple>()
    val exercise: LiveData<ExerciseWithNetworkTuple>
        get() = _exercise

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shouldAlertShow = MutableLiveData<Boolean>()
    val shouldAlertShow: LiveData<Boolean>
        get() = _shouldAlertShow

    init {
        _exercise.value = exercisesArgs[count]
    }



    fun addItem(inputKg: String, inputReps: String){
        val reps = parseCount(inputReps)
        val kg = parseCount(inputKg)
        if (validateInput(reps,kg)){
            countSets+=1
            _progress.value = ((countSets/exercisesArgs[count].exercise.sets.toFloat()) * 100).toInt()
            _progressText.value = "$countSets/${exercisesArgs[count].exercise.sets}"
        }
    }

    fun newPage(){
        count+=1
        countSets = 1
        if (count >= exercisesArgs.size) {
            viewModelScope.launch {
                updateActiveToInactiveUseCase(dayId)

            }
            _shouldAlertShow.value = true
        }
        else{
            _exercise.value = exercisesArgs[count]
        }

    }


    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(inputReps: Int, inputKg: Int): Boolean {
        if (inputReps<= 0  || inputKg<= 0 ) {
            _errorInputCount.value = true
            return false
        }
        _errorInputCount.value = false
        return true
    }

}