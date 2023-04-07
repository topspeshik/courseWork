package com.example.kursovaya.domain.Food.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food (
    val id: Int?,
    val name: String?,
    val proteins: Int?,
    val fats: Int?,
    val carb: Int?,
    val kcal: Int?
) : Parcelable