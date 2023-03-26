package com.example.kursovaya.domain.db.ExerciseList

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class ExerciseItem @Inject constructor (
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