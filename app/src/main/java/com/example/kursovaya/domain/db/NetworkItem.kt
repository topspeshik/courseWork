package com.example.kursovaya.domain.db

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NetworkItem (
    val exercise_name: String,
    val urlimg: String,
    val urlgif: String

): Parcelable
