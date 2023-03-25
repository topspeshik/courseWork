package com.example.kursovaya.presentation

import android.app.Application
import androidx.lifecycle.*
import com.example.kursovaya.data.db.AppDatabase
import com.example.kursovaya.data.db.NetworkList.NetworkListDao
import com.example.kursovaya.data.db.NetworkList.NetworkListMapper
import com.example.kursovaya.data.db.NetworkList.NetworkRepositoryImpl
import com.example.kursovaya.data.db.models.NetworkItemDbModel
import com.example.kursovaya.data.network.ApiFactory
import com.example.kursovaya.data.network.ApiFactory.apiService
import com.example.kursovaya.data.network.TrainingMapper
import com.example.kursovaya.data.network.TrainingRepositoryImpl
import com.example.kursovaya.domain.db.Network.NetworkItem
import com.example.kursovaya.domain.db.Network.addNetworkItemUseCase
import com.example.kursovaya.domain.db.Network.searchNameUseCase
import com.example.kursovaya.domain.network.TrainingRepository
import com.example.kursovaya.domain.network.getTrainingListUseCase
import com.example.kursovaya.domain.network.getUpdateInfoUseCase
import kotlinx.coroutines.launch

class AddDayViewModel(application: Application)  : AndroidViewModel(application) {


    private val trainingRepository = TrainingRepositoryImpl(ApiFactory, TrainingMapper())
    private val getTrainingListUseCase = getTrainingListUseCase(trainingRepository)
    private val getUpdateInfoUseCase = getUpdateInfoUseCase(trainingRepository)

    private val networkRepository = NetworkRepositoryImpl(application)
    private val addNetworkItemUseCase = addNetworkItemUseCase(networkRepository)
    private val searchNameUseCase = searchNameUseCase(networkRepository)

    private val appDatabase = AppDatabase.getInstance(application)
    private var lastUpdate: String = ""

    fun getTrainingList(sym: String): LiveData<List<NetworkItem>> {
        loadData()
        return searchNameUseCase("%$sym%")

    }

    private fun loadData(){
        viewModelScope.launch {
            val update = getUpdateInfoUseCase()
            if (update.date.toString() != lastUpdate){
                val tList = getTrainingListUseCase()
                for (training in tList){
                    addNetworkItemUseCase(
                        NetworkItem(
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