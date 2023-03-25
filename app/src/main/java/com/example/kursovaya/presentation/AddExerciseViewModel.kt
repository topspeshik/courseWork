package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kursovaya.data.db.AppDatabase
import com.example.kursovaya.data.db.ExerciseList.ExerciseListRepositoryImpl
import com.example.kursovaya.data.db.models.DayExerciseSettingsDbModel
import com.example.kursovaya.data.db.models.ExerciseItemDbModel
import com.example.kursovaya.domain.db.ExerciseList.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AddExerciseViewModel(application: Application) : AndroidViewModel(application) {


    private val exerciseListRepository = ExerciseListRepositoryImpl(application)
    private val addExerciseItemUseCase: addExerciseItemUseCase = addExerciseItemUseCase(exerciseListRepository)
    private val getCurrentIdUseCase: getCurrentIdUseCase = getCurrentIdUseCase(exerciseListRepository)


    private val appDatabase = AppDatabase.getInstance(getApplication())
    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shouldCloseScreen = MutableLiveData<Boolean>()
    val shouldCloseScreen: LiveData<Boolean>
        get() = _shouldCloseScreen

    fun addExerciseItem(day_id: Int, ex_name: String, inputSets: String, inputReps: String, inputKg: String) {
        val sets = parseCount(inputSets)
        val reps = parseCount(inputReps)
        val kg = parseCount(inputKg)
        if (validateInput(sets,reps,kg)) {
            viewModelScope.launch {
                addExerciseItemUseCase(
                    ExerciseItem(
                        ex_name,
                        sets,
                        reps,
                        kg
                    )
                )
                withContext(Dispatchers.IO){
                    val exercise_id = getCurrentIdUseCase()
                    appDatabase.dayExerciseSettingsDao().addDayExerciseItem(
                        DayExerciseSettingsDbModel(
                            day_id,
                            exercise_id ,
                            1
                        )
                    )
                }

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