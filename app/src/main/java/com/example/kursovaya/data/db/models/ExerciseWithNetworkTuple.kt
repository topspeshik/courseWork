package com.example.kursovaya.data.db.models

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.example.kursovaya.data.db.models.ExerciseItemDbModel
import com.example.kursovaya.data.db.models.NetworkItemDbModel

@kotlinx.parcelize.Parcelize
data class ExerciseWithNetworkTuple (

    @Embedded
    val exercise: ExerciseItemDbModel,

    @Relation(parentColumn = "name", entityColumn = "exercise_name")
    val network: NetworkItemDbModel
): Parcelable