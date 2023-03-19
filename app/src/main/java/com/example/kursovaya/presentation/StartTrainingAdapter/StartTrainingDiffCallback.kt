package com.example.kursovaya.presentation.StartTrainingAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kursovaya.data.db.ExerciseItemDbModel


object StartTrainingDiffCallback : DiffUtil.ItemCallback<ExerciseItemDbModel>() {

    override fun areItemsTheSame(oldItem: ExerciseItemDbModel, newItem: ExerciseItemDbModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ExerciseItemDbModel, newItem: ExerciseItemDbModel): Boolean {
        return oldItem == newItem
    }
}