package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.*
import com.example.kursovaya.data.model.Training
import com.example.kursovaya.data.network.ApiFactory.apiService
import kotlinx.coroutines.launch

class AddDayViewModel(application: Application)  : AndroidViewModel(application) {

    private val _trainingList =  MutableLiveData<List<Training>>()
    val trainingList: LiveData<List<Training>>
        get() = _trainingList

    fun searchViewFind(sym: String) {
        viewModelScope.launch {
            _trainingList.value = apiService.getTrainingList()
                .filter { training -> training.name!!.startsWith(sym) }
        }
    }








}