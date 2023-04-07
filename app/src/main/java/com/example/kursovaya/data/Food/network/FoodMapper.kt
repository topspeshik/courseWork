package com.example.kursovaya.data.Training.network

import com.example.kursovaya.data.Training.network.model.FoodDto
import com.example.kursovaya.data.Training.network.model.TrainingDto
import com.example.kursovaya.data.Training.network.model.UpdateDateDto
import com.example.kursovaya.data.Training.network.model.UpdateFoodDateDto
import com.example.kursovaya.domain.Food.network.Food
import com.example.kursovaya.domain.Training.network.Training
import com.example.kursovaya.domain.Training.network.UpdateDate
import javax.inject.Inject

class FoodMapper  @Inject constructor(){
    fun mapFoodDtoToEntity(foodDto: FoodDto) = Food(
        id = foodDto.id,
        name = foodDto.name,
        proteins = foodDto.proteins,
        carb = foodDto.carb,
        fats = foodDto.fats,
        kcal = foodDto.kcal
    )

    fun mapUpdateDtoToEntity(updateDateFoodDto: UpdateFoodDateDto) = UpdateDate(
        date = updateDateFoodDto.date
    )

    fun mapFoodListDtoToEntity(list: List<FoodDto>) = list.map{
        mapFoodDtoToEntity(it)
    }

}