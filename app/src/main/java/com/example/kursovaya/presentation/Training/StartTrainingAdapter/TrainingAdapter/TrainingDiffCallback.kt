package com.example.kursovaya.presentation.Training.StartTrainingAdapter.TrainingAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kursovaya.domain.Training.db.DayExerciseSettings.DayExerciseSettings


class TrainingDiffCallback : DiffUtil.ItemCallback<DayExerciseSettings>() {

    override fun areItemsTheSame(oldItem: DayExerciseSettings, newItem: DayExerciseSettings): Boolean {
        return oldItem.day_id == newItem.day_id
    }

    override fun areContentsTheSame(oldItem: DayExerciseSettings, newItem: DayExerciseSettings): Boolean {
        return oldItem == newItem
    }
}