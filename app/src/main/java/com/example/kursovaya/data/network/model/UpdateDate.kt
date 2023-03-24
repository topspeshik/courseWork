package com.example.kursovaya.data.network.model

import com.google.gson.annotations.SerializedName

data class UpdateDate (
    @SerializedName("date")
    val date: String?,
)