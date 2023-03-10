package com.example.kursovaya.data.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(
    tableName = "exercise_items",
//    primaryKeys = ["day_id","exercise_id"]

)

data class ExerciseItemDbModel (
    val day_id: Int,
    val exercise_name: String,
    val sets: Int,
    val reps: Int,
    val kg: Int,
    val urlimg: String,
    val urlgif: String

): Parcelable
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="exercise_id") var exercise_id: Int = 0
}