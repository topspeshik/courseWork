package com.example.kursovaya.data.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@kotlinx.parcelize.Parcelize
@Entity(
    tableName = "exercise_items",
    foreignKeys = [
        ForeignKey(
            entity = NetworkItemDbModel::class,
            parentColumns = ["exercise_name"],
            childColumns = ["name"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )]
)

data class ExerciseItemDbModel (
    val name: String,
    val sets: Int,
    val reps: Int,
    val kg: Int

): Parcelable
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") var id: Int = 0
}