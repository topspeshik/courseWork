package com.example.kursovaya.presentation.AddDayAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kursovaya.data.db.models.NetworkItemDbModel

object AddExerciseDiffCallback : DiffUtil.ItemCallback<NetworkItemDbModel>() {

    override fun areItemsTheSame(oldItem: NetworkItemDbModel, newItem: NetworkItemDbModel): Boolean {
        return oldItem.exercise_name == newItem.exercise_name
    }

    override fun areContentsTheSame(oldItem: NetworkItemDbModel, newItem: NetworkItemDbModel): Boolean {
        return oldItem == newItem
    }
}