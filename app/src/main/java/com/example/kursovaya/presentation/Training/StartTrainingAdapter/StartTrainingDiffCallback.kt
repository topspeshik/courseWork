package com.example.kursovaya.presentation.Training.StartTrainingAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kursovaya.domain.Training.db.DayExerciseSettings.ExerciseWithNetworkTuple


object StartTrainingDiffCallback : DiffUtil.ItemCallback<ExerciseWithNetworkTuple>() {

    override fun areItemsTheSame(oldItem: ExerciseWithNetworkTuple, newItem: ExerciseWithNetworkTuple): Boolean {
        return oldItem.exercise.id == newItem.exercise.id
    }

    override fun areContentsTheSame(oldItem: ExerciseWithNetworkTuple, newItem: ExerciseWithNetworkTuple): Boolean {
        return oldItem == newItem
    }
}