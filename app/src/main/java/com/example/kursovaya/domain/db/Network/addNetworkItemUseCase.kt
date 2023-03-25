package com.example.kursovaya.domain.db.Network

class addNetworkItemUseCase(
    private val repository: NetworkRepository
) {
    suspend operator fun invoke(networkItem: NetworkItem) = repository.addNetworkItem(networkItem)
}