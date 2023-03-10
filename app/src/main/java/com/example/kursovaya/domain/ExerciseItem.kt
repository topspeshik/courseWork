package com.example.kursovaya.domain

data class ExerciseItem (
    val day_id: Int,
    val exercise_id: Int,
    val exercise_name: String,
    val sets: Int,
    val reps: Int,
    val kg: Int,
    val urlimg: String,
    val urlgif: String


)