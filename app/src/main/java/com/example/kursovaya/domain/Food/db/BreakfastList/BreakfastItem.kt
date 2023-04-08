package com.example.kursovaya.domain.Food.db.BreakfastList

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class BreakfastItem @Inject constructor(
    val food_name: String,
    val weight: Int,
    val id: Int = UNDEFINED_ID

) :Parcelable
{
    companion object {

        const val UNDEFINED_ID = 0
    }
}