package com.example.kursovaya.data.Food.db.BreakfastList

import com.example.kursovaya.data.Food.db.FoodNetwork.FoodNetworkListMapper
import com.example.kursovaya.data.Food.db.models.BreakfastItemDbModel
import com.example.kursovaya.data.Food.db.models.BreakfastWithFoodTupleDbModel
import com.example.kursovaya.domain.Food.db.BreakfastList.BreakfastItem
import com.example.kursovaya.domain.Food.db.BreakfastList.BreakfastWithFoodTuple
import javax.inject.Inject


class BreakfastListMapper @Inject constructor(){

    private val foodMapper = FoodNetworkListMapper()

    private fun mapBreakfastDbToEntity(breakfastItemDbModel: BreakfastItemDbModel) = BreakfastItem(
        mealTime = breakfastItemDbModel.mealTime,
        food_name = breakfastItemDbModel.food_name,
        weight = breakfastItemDbModel.weight,
        id = breakfastItemDbModel.id
    )

    fun mapEntityToBreakfastDb(breakfastItem: BreakfastItem) = BreakfastItemDbModel(
        mealTime = breakfastItem.mealTime,
        food_name = breakfastItem.food_name,
        weight = breakfastItem.weight
    )

    fun mapBreakfastListDbToListEntity(list: List<BreakfastItemDbModel>) = list.map{
        mapBreakfastDbToEntity(it)
    }


    private fun mapTupleDbToEntity(breakfastWithFoodTupleDbModel: BreakfastWithFoodTupleDbModel) = BreakfastWithFoodTuple(
        breakfastItem = mapBreakfastDbToEntity(breakfastWithFoodTupleDbModel.breakfastItem),
        foodItem = foodMapper.mapNetworkDbToEntity(breakfastWithFoodTupleDbModel.foodItem)

    )

    fun mapListTupleDbToEntity(list: List<BreakfastWithFoodTupleDbModel>) = list.map{
        mapTupleDbToEntity(it)
    }



}