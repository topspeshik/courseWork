package com.example.kursovaya.domain.Training.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Training (
    val id: String?,
    val name: String?,
    val urlimg: String?,
    val urlgif: String?
) : Parcelable