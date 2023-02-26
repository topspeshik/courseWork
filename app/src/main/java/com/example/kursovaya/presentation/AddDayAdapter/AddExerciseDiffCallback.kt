package com.example.kursovaya.presentation.AddDayAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kursovaya.data.model.Training

object AddExerciseDiffCallback : DiffUtil.ItemCallback<Training>() {

    override fun areItemsTheSame(oldItem: Training, newItem: Training): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Training, newItem: Training): Boolean {
        return oldItem == newItem
    }
}