package com.example.kursovaya.data.Food.db.models

import androidx.room.Embedded
import androidx.room.Relation

data class BreakfastWithFoodTupleDbModel (

    @Embedded
    val breakfastItem: BreakfastItemDbModel,

    @Relation(parentColumn = "food_name", entityColumn = "name")
    val foodItem: FoodItemDbModel
)