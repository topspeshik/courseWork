package com.example.kursovaya.domain.db.NetworkList

class addNetworkItemUseCase(
    private val repository: NetworkRepository
) {
    suspend operator fun invoke(networkItem: NetworkItem) = repository.addNetworkItem(networkItem)
}