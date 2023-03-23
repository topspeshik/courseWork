package com.example.kursovaya.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.kursovaya.data.network.model.Training
import com.example.kursovaya.data.network.ApiFactory.apiService
import kotlinx.coroutines.launch

class AddDayViewModel(application: Application)  : AndroidViewModel(application) {

    private val _trainingList =  MutableLiveData<List<Training>>()
    val trainingList: LiveData<List<Training>>
        get() = _trainingList

    fun searchViewFind(sym: String) {
        Log.d("checkshit",sym.isNotBlank().toString())
        if (sym.isNotBlank()) {
            viewModelScope.launch {
                _trainingList.value = apiService.getTrainingList()
                    .filter { training -> training.name!!
                        .lowercase()
                        .startsWith(sym.lowercase()) }
            }
        }
    }








}