package com.example.kursovaya.domain.db.Network

import androidx.lifecycle.LiveData

interface NetworkRepository {

    suspend fun addNetworkItem(networkItem: NetworkItem)

    fun searchName(sym: String): LiveData<List<NetworkItem>>
}