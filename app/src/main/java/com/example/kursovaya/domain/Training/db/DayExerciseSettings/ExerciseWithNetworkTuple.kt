package com.example.kursovaya.domain.Training.db.DayExerciseSettings

import android.os.Parcelable
import com.example.kursovaya.domain.Training.db.ExerciseList.ExerciseItem
import com.example.kursovaya.domain.Training.db.NetworkList.NetworkItem
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class ExerciseWithNetworkTuple @Inject constructor(

    val exercise: ExerciseItem,

    val network: NetworkItem
): Parcelable