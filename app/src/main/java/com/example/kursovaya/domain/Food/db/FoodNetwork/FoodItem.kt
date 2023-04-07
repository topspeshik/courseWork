package com.example.kursovaya.domain.Food.db.FoodNetwork

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class FoodItem @Inject constructor(
    val name: String,
    val proteins: Int,
    val fats: Int,
    val carb: Int,
    val kcal: Int

): Parcelable
