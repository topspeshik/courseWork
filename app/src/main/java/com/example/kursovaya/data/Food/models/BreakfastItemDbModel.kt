package com.example.kursovaya.data.Food.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "breakfast_items",

)

data class BreakfastItemDbModel (
    val name: Int,
    val weight: Int,
    val kcal: Int

)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") var id: Int = 0
}