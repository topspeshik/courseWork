package com.example.kursovaya.presentation.TrainingAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kursovaya.data.db.ExerciseItemDbModel


object TrainingDiffCallback : DiffUtil.ItemCallback<Int>() {

    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }
}