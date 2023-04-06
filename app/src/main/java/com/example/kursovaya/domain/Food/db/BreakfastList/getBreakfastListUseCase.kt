package com.example.kursovaya.domain.Food.db.BreakfastList

import javax.inject.Inject

class getBreakfastListUseCase @Inject constructor(
    private val repository: BreakfastListRepository
) {
    operator fun invoke() = repository.getBreakfastList()
}