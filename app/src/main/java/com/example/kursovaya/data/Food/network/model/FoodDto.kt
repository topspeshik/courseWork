package com.example.kursovaya.data.Training.network.model


import com.google.gson.annotations.SerializedName


data class FoodDto (
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("proteins")
    val proteins: Int?,
    @SerializedName("fats")
    val fats: Int?,
    @SerializedName("carb")
    val carb: Int?,
    @SerializedName("kcal")
    val kcal: Int?
)