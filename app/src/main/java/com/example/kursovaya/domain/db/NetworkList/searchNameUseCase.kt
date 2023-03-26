package com.example.kursovaya.domain.db.NetworkList

import javax.inject.Inject

class searchNameUseCase @Inject constructor(
    private val repository: NetworkRepository
) {
    operator fun invoke(sym: String) = repository.searchName(sym)
}