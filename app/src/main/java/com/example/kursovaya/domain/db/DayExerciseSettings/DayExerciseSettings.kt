package com.example.kursovaya.domain.db.DayExerciseSettings

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayExerciseSettings (
    val day_id: Int,
    val exercise_id: Int,
    val active: Int,
    var dayExercise_id: Int = UNDEFINED_ID

): Parcelable
{
    companion object {

        const val UNDEFINED_ID = 0
    }
}