package com.example.kursovaya.data.Food.BreakfastList

import com.example.kursovaya.data.Food.models.BreakfastItemDbModel
import com.example.kursovaya.data.Training.db.models.ExerciseItemDbModel
import com.example.kursovaya.domain.Food.db.BreakfastList.BreakfastItem
import com.example.kursovaya.domain.Training.db.ExerciseList.ExerciseItem
import javax.inject.Inject


class BreakfastListMapper @Inject constructor(){

    fun mapBreakfastDbToEntity(breakfastItemDbModel: BreakfastItemDbModel) = BreakfastItem(
        name = breakfastItemDbModel.name,
        kcal = breakfastItemDbModel.kcal,
        id = breakfastItemDbModel.id,
        weight = breakfastItemDbModel.weight
    )

    fun mapEntityToBreakfastDb(breakfastItem: BreakfastItem) = BreakfastItemDbModel(
        name = breakfastItem.name,
        kcal = breakfastItem.kcal,
        weight = breakfastItem.weight
    )

    fun mapBreakfastListDbToListEntity(list: List<BreakfastItemDbModel>) = list.map{
        mapBreakfastDbToEntity(it)
    }



}