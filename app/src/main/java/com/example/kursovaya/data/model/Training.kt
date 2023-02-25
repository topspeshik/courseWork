package com.example.kursovaya.data.model

import com.google.gson.annotations.SerializedName

data class Training (
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("urlimg")
    val urlimg: String?
)