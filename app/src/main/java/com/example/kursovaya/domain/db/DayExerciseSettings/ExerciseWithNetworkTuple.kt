package com.example.kursovaya.domain.db.DayExerciseSettings

import android.os.Parcelable
import com.example.kursovaya.data.db.models.ExerciseItemDbModel
import com.example.kursovaya.data.db.models.NetworkItemDbModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExerciseWithNetworkTuple (

    val exercise: ExerciseItemDbModel,

    val network: NetworkItemDbModel
): Parcelable