package com.example.kursovaya.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "exercise_items",
//    primaryKeys = ["day_id","exercise_id"]

)

data class ExerciseItemDbModel (
    val day_id: Int,
    val exercise_name: String,
    val sets: String,
    val reps: String,
    val kg: String

)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="exercise_id") var exercise_id: Int = 0
}