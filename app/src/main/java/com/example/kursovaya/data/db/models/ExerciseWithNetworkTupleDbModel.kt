package com.example.kursovaya.data.db.models


import androidx.room.Embedded
import androidx.room.Relation

data class ExerciseWithNetworkTupleDbModel (

    @Embedded
    val exercise: ExerciseItemDbModel,

    @Relation(parentColumn = "name", entityColumn = "exercise_name")
    val network: NetworkItemDbModel
)