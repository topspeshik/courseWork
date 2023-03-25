package com.example.kursovaya.domain.db.NetworkList

class searchNameUseCase(
    private val repository: NetworkRepository
) {
    operator fun invoke(sym: String) = repository.searchName(sym)
}