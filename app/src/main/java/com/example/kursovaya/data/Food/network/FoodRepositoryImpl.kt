package com.example.kursovaya.data.Food.network

import com.example.kursovaya.data.Training.network.ApiFactoryFood
import com.example.kursovaya.data.Training.network.FoodMapper
import com.example.kursovaya.domain.Food.network.Food
import com.example.kursovaya.domain.Food.network.FoodRepository
import com.example.kursovaya.domain.Food.network.UpdateFoodDate
import com.example.kursovaya.domain.Training.network.Training
import com.example.kursovaya.domain.Training.network.TrainingRepository
import com.example.kursovaya.domain.Training.network.UpdateDate
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val apiFactory: ApiFactoryFood,
    private val mapper: FoodMapper
    ) : FoodRepository {

    override suspend fun getFoodList(): List<Food> {
        val foodModel = apiFactory.apiService.getFoodList()
        return mapper.mapFoodListDtoToEntity(foodModel)
    }

    override suspend fun getUpdateInfo(): UpdateDate {
        val updateModel = apiFactory.apiService.getUpdateInfo()
        return mapper.mapUpdateDtoToEntity(updateModel)
    }
}