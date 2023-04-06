package com.example.kursovaya.presentation.Training.StartTrainingAdapter

import androidx.lifecycle.*
import com.example.kursovaya.domain.Training.db.DayExerciseSettings.DayExerciseSettings
import com.example.kursovaya.domain.Training.db.DayExerciseSettings.addDayExerciseItemUseCase
import com.example.kursovaya.domain.Training.db.ExerciseList.ExerciseItem
import com.example.kursovaya.domain.Training.db.ExerciseList.addExerciseItemUseCase
import com.example.kursovaya.domain.Training.db.ExerciseList.getCurrentIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class AddExerciseViewModel @Inject constructor(
    private val addExerciseItemUseCase: addExerciseItemUseCase,
    private val getCurrentIdUseCase: getCurrentIdUseCase,
    private val addDayExerciseItemUseCase : addDayExerciseItemUseCase
) : ViewModel() {


//    private val exerciseListRepository = ExerciseListRepositoryImpl(application)
//    private val addExerciseItemUseCase: addExerciseItemUseCase = addExerciseItemUseCase(exerciseListRepository)
//    private val getCurrentIdUseCase: getCurrentIdUseCase = getCurrentIdUseCase(exerciseListRepository)
//
//
//    private val dayExerciseSettingsRepository = DayExerciseSettingsRepositoryImpl(application)
//    private val addDayExerciseItemUseCase = addDayExerciseItemUseCase(dayExerciseSettingsRepository)


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
                    addDayExerciseItemUseCase(
                        DayExerciseSettings(
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