package com.example.kursovaya.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "exercise_items",
    primaryKeys = ["day_id","exercise_id"]

)

data class ExerciseItemDbModel (
    @ColumnInfo(name="day_id") val day_id: Int,
    @ColumnInfo(name="exercise_id") val exercise_id: Int,
    val exercise_name: String,
    val sets: String,
    val reps: String,
    val kg: String

)