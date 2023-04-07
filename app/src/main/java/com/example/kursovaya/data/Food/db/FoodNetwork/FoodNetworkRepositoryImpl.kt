package com.example.kursovaya.data.Food.db.FoodNetwork

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem
import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodNetworkRepository
import com.example.kursovaya.domain.Training.db.NetworkList.NetworkItem
import com.example.kursovaya.domain.Training.db.NetworkList.NetworkRepository
import javax.inject.Inject

class FoodNetworkRepositoryImpl @Inject constructor(
    private val foodNetworkListDao: FoodNetworkListDao,
    private val mapper: FoodNetworkListMapper
) : FoodNetworkRepository {
//    private val networkListDao: NetworkListDao = AppDatabase.getInstance(application).networkListDao()
//    private val mapper: NetworkListMapper = NetworkListMapper()

    override suspend fun addNetworkItem(foodItem: FoodItem) {
        foodNetworkListDao.addNetworkItem(mapper.mapEntityToNetoworkDb(foodItem))
    }

    override fun searchName(sym: String): LiveData<List<FoodItem>> {
         return Transformations.map(foodNetworkListDao.searchName(sym)){
             mapper.mapListNetworkDbToListEntity(it)
         }
    }
}