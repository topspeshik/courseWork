package com.example.kursovaya.domain.db

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExerciseItem (
    val name: String,
    val sets: Int,
    val reps: Int,
    val kg: Int,
    var id: Int = UNDEFINED_ID
): Parcelable
{
    companion object {

        const val UNDEFINED_ID = 0
    }
}