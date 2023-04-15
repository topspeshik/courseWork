package com.example.kursovaya.domain.Food.db.MealsList

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class MealsItem @Inject constructor(
    val mealTime: String,
    val food_name: String,
    val weight: Int,
    val id: Int = UNDEFINED_ID

) :Parcelable
{
    companion object {

        const val UNDEFINED_ID = 0
    }
}