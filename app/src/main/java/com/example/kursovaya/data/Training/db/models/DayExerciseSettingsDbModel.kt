package com.example.kursovaya.data.Training.db.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "day_exercise_settings_items",
    foreignKeys = [
        ForeignKey(
            entity = ExerciseItemDbModel::class,
            parentColumns = ["id"],
            childColumns = ["exercise_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )]
)

data class DayExerciseSettingsDbModel (
    val day_id: Int,
    val exercise_id: Int,
    val active: Int

)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="dayExercise_id") var dayExercise_id: Int = 0
}