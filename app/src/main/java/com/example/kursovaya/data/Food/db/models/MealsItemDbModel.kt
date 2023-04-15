package com.example.kursovaya.data.Food.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "breakfast_items",
    foreignKeys = [
        ForeignKey(
            entity = FoodItemDbModel::class,
            parentColumns = ["name"],
            childColumns = ["food_name"]
        )]
)

data class MealsItemDbModel (
    val mealTime: String,
    val food_name: String,
    val weight: Int

)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") var id: Int = 0
}