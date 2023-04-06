package com.example.kursovaya.domain.Training.db.NetworkList

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class NetworkItem @Inject constructor(
    val exercise_name: String,
    val urlimg: String,
    val urlgif: String

): Parcelable
