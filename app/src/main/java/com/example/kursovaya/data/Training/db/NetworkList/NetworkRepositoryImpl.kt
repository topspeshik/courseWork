package com.example.kursovaya.data.Training.db.NetworkList

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.kursovaya.domain.Training.db.NetworkList.NetworkItem
import com.example.kursovaya.domain.Training.db.NetworkList.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val networkListDao: NetworkListDao,
    private val mapper: NetworkListMapper
) : NetworkRepository {
//    private val networkListDao: NetworkListDao = AppDatabase.getInstance(application).networkListDao()
//    private val mapper: NetworkListMapper = NetworkListMapper()

    override suspend fun addNetworkItem(networkItem: NetworkItem) {
        networkListDao.addNetworkItem(mapper.mapEntityToNetoworkDb(networkItem))
    }

    override fun searchName(sym: String): LiveData<List<NetworkItem>> {
         return Transformations.map(networkListDao.searchName(sym)){
             mapper.mapListNetworkDbToListEntity(it)
         }
    }
}