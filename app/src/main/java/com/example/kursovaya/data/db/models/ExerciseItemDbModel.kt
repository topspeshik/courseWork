package com.example.kursovaya.data.db.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey



@Entity(
    tableName = "exercise_items",
    foreignKeys = [
        ForeignKey(
            entity = NetworkItemDbModel::class,
            parentColumns = ["exercise_name"],
            childColumns = ["name"]
        )]
)

data class ExerciseItemDbModel (
    val name: String,
    val sets: Int,
    val reps: Int,
    val kg: Int

)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") var id: Int = 0
}