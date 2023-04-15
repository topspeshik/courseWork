package com.example.kursovaya.domain.Food.db.MealsList


import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem

data class MealsWithFoodTuple(


    val mealsItem: MealsItem,

    val foodItem: FoodItem
)