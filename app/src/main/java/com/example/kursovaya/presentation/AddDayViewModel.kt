package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.*
import com.example.kursovaya.data.db.AppDatabase
import com.example.kursovaya.data.db.models.NetworkItemDbModel
import com.example.kursovaya.data.network.ApiFactory.apiService
import kotlinx.coroutines.launch

class AddDayViewModel(application: Application)  : AndroidViewModel(application) {

    private val appDatabase = AppDatabase.getInstance(application)
    private var lastUpdate: String = ""

    fun getTrainingList(sym: String): LiveData<List<NetworkItemDbModel>> {
        loadData()
        return appDatabase.networkListDao().searchName("%$sym%")

    }

    private fun loadData(){
        viewModelScope.launch {
            val update = apiService.getUpdateInfo()
            if (update.date.toString() != lastUpdate){
                val tList = apiService.getTrainingList()
                for (training in tList){
                    appDatabase.networkListDao().addNetworkItem(
                        NetworkItemDbModel(
                            training.name!!,
                            training.urlimg!!,
                            training.urlgif!!
                        )
                    )
                }
            }
            lastUpdate = update.date.toString()
        }

    }








}