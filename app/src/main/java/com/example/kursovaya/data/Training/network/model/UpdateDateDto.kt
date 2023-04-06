package com.example.kursovaya.data.Training.network.model

import com.google.gson.annotations.SerializedName

data class UpdateDateDto (
    @SerializedName("date")
    val date: String?
)