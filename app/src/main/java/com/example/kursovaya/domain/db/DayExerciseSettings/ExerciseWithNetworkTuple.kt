package com.example.kursovaya.domain.db.DayExerciseSettings

import android.os.Parcelable
import com.example.kursovaya.data.db.models.ExerciseItemDbModel
import com.example.kursovaya.data.db.models.NetworkItemDbModel
import com.example.kursovaya.domain.db.ExerciseList.ExerciseItem
import com.example.kursovaya.domain.db.NetworkList.NetworkItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExerciseWithNetworkTuple (

    val exercise: ExerciseItem,

    val network: NetworkItem
): Parcelable