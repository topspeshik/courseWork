package com.example.kursovaya.presentation.TrainingAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kursovaya.domain.db.DayExerciseSettings.DayExerciseSettings


class TrainingDiffCallback : DiffUtil.ItemCallback<DayExerciseSettings>() {

    override fun areItemsTheSame(oldItem: DayExerciseSettings, newItem: DayExerciseSettings): Boolean {
        return oldItem.day_id == newItem.day_id
    }

    override fun areContentsTheSame(oldItem: DayExerciseSettings, newItem: DayExerciseSettings): Boolean {
        return oldItem == newItem
    }
}