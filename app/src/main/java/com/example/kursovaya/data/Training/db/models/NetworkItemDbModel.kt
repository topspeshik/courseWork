package com.example.kursovaya.data.Training.db.models


import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(
    tableName = "network_items"
)

data class NetworkItemDbModel (
    @PrimaryKey()
    val exercise_name: String,
    val urlimg: String,
    val urlgif: String

)
