package com.example.kursovaya.presentation.AddDayAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kursovaya.data.db.models.NetworkItemDbModel
import com.example.kursovaya.domain.db.Network.NetworkItem

object AddExerciseDiffCallback : DiffUtil.ItemCallback<NetworkItem>() {

    override fun areItemsTheSame(oldItem: NetworkItem, newItem: NetworkItem): Boolean {
        return oldItem.exercise_name == newItem.exercise_name
    }

    override fun areContentsTheSame(oldItem: NetworkItem, newItem: NetworkItem): Boolean {
        return oldItem == newItem
    }
}