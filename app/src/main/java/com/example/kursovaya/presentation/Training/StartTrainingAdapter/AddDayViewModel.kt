package com.example.kursovaya.presentation.Training.StartTrainingAdapter

import androidx.lifecycle.*
import com.example.kursovaya.domain.Training.db.NetworkList.NetworkItem
import com.example.kursovaya.domain.Training.db.NetworkList.addNetworkItemUseCase
import com.example.kursovaya.domain.Training.db.NetworkList.searchNameUseCase
import com.example.kursovaya.domain.Training.network.getTrainingListUseCase
import com.example.kursovaya.domain.Training.network.getUpdateInfoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddDayViewModel @Inject constructor(
    private val getTrainingListUseCase : getTrainingListUseCase,
    private val getUpdateInfoUseCase : getUpdateInfoUseCase,
    private val addNetworkItemUseCase : addNetworkItemUseCase,
    private val searchNameUseCase : searchNameUseCase
)  : ViewModel() {


//    private val trainingRepository = TrainingRepositoryImpl(ApiFactory, TrainingMapper())
//    private val getTrainingListUseCase = getTrainingListUseCase(trainingRepository)
//    private val getUpdateInfoUseCase = getUpdateInfoUseCase(trainingRepository)
//
//    private val networkRepository = NetworkRepositoryImpl(application)
//    private val addNetworkItemUseCase = addNetworkItemUseCase(networkRepository)
//    private val searchNameUseCase = searchNameUseCase(networkRepository)
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