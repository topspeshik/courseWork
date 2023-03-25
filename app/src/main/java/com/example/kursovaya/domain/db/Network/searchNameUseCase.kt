package com.example.kursovaya.domain.db.Network

class searchNameUseCase(
    private val repository: NetworkRepository
) {
    operator fun invoke(sym: String) = repository.searchName(sym)
}