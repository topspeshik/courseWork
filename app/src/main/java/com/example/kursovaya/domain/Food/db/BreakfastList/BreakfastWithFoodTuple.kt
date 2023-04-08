package com.example.kursovaya.domain.Food.db.BreakfastList


import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem

data class BreakfastWithFoodTuple(


    val breakfastItem: BreakfastItem,

    val foodItem: FoodItem
)