package com.example.kursovaya.data.Food.db.MealsList

import com.example.kursovaya.data.Food.db.FoodNetwork.FoodNetworkListMapper
import com.example.kursovaya.data.Food.db.models.MealsItemDbModel
import com.example.kursovaya.data.Food.db.models.MealsWithFoodTupleDbModel
import com.example.kursovaya.domain.Food.db.MealsList.MealsItem
import com.example.kursovaya.domain.Food.db.MealsList.MealsWithFoodTuple
import javax.inject.Inject


class MealsListMapper @Inject constructor(){

    private val foodMapper = FoodNetworkListMapper()

    private fun mapBreakfastDbToEntity(mealsItemDbModel: MealsItemDbModel) = MealsItem(
        mealTime = mealsItemDbModel.mealTime,
        food_name = mealsItemDbModel.food_name,
        weight = mealsItemDbModel.weight,
        id = mealsItemDbModel.id
    )

    fun mapEntityToBreakfastDb(mealsItem: MealsItem) = MealsItemDbModel(
        mealTime = mealsItem.mealTime,
        food_name = mealsItem.food_name,
        weight = mealsItem.weight
    )

    fun mapBreakfastListDbToListEntity(list: List<MealsItemDbModel>) = list.map{
        mapBreakfastDbToEntity(it)
    }


    private fun mapTupleDbToEntity(mealsWithFoodTupleDbModel: MealsWithFoodTupleDbModel) = MealsWithFoodTuple(
        mealsItem = mapBreakfastDbToEntity(mealsWithFoodTupleDbModel.breakfastItem),
        foodItem = foodMapper.mapNetworkDbToEntity(mealsWithFoodTupleDbModel.foodItem)

    )

    fun mapListTupleDbToEntity(list: List<MealsWithFoodTupleDbModel>) = list.map{
        mapTupleDbToEntity(it)
    }



}