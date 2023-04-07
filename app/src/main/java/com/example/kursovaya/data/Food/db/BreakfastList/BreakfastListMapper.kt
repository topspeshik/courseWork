package com.example.kursovaya.data.Food.db.BreakfastList

import com.example.kursovaya.data.Food.db.models.BreakfastItemDbModel
import com.example.kursovaya.domain.Food.db.BreakfastList.BreakfastItem
import javax.inject.Inject


class BreakfastListMapper @Inject constructor(){

    fun mapBreakfastDbToEntity(breakfastItemDbModel: BreakfastItemDbModel) = BreakfastItem(
        food_name = breakfastItemDbModel.food_name,
        id = breakfastItemDbModel.id
    )

    fun mapEntityToBreakfastDb(breakfastItem: BreakfastItem) = BreakfastItemDbModel(
        food_name = breakfastItem.food_name
    )

    fun mapBreakfastListDbToListEntity(list: List<BreakfastItemDbModel>) = list.map{
        mapBreakfastDbToEntity(it)
    }



}