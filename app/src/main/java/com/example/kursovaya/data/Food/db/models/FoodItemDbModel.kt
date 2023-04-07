package com.example.kursovaya.data.Food.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(
    tableName = "FoodNetwork_items"
)

data class FoodItemDbModel (
    @PrimaryKey()
    val name: String,
    val proteins: Int,
    val fats: Int,
    val carb: Int,
    val kcal: Int
)