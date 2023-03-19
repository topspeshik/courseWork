package com.example.kursovaya.data.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@kotlinx.parcelize.Parcelize
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
    val exercise_id: Int,
    val active: Int

): Parcelable
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="day_id") var day_id: Int = 0
}