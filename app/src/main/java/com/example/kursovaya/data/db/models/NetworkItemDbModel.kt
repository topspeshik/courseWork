package com.example.kursovaya.data.db.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@kotlinx.parcelize.Parcelize
@Entity(
    tableName = "network_items"
)

data class NetworkItemDbModel (
    @PrimaryKey()
    val exercise_name: String,
    val urlimg: String,
    val urlgif: String

): Parcelable
