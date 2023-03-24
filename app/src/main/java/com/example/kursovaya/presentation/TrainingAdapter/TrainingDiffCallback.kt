package com.example.kursovaya.presentation.TrainingAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kursovaya.data.db.models.DayExerciseSettingsDbModel


class TrainingDiffCallback : DiffUtil.ItemCallback<DayExerciseSettingsDbModel>() {

    override fun areItemsTheSame(oldItem: DayExerciseSettingsDbModel, newItem: DayExerciseSettingsDbModel): Boolean {
        return oldItem.day_id == newItem.day_id
    }

    override fun areContentsTheSame(oldItem: DayExerciseSettingsDbModel, newItem: DayExerciseSettingsDbModel): Boolean {
        return oldItem == newItem
    }
}