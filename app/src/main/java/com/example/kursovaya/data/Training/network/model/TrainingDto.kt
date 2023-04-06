package com.example.kursovaya.data.Training.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TrainingDto (
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("urlimg")
    val urlimg: String?,
    @SerializedName("urlgif")
    val urlgif: String?
) : Parcelable