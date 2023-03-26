package com.example.kursovaya.domain.db.NetworkList

import javax.inject.Inject

class addNetworkItemUseCase @Inject constructor(
    private val repository: NetworkRepository
) {
    suspend operator fun invoke(networkItem: NetworkItem) = repository.addNetworkItem(networkItem)
}