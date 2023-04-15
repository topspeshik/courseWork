package com.example.kursovaya.data.Food.db.models

import androidx.room.Embedded
import androidx.room.Relation

data class MealsWithFoodTupleDbModel (

    @Embedded
    val breakfastItem: MealsItemDbModel,

    @Relation(parentColumn = "food_name", entityColumn = "name")
    val foodItem: FoodItemDbModel
)