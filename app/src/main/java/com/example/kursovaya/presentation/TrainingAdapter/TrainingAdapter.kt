package com.example.kursovaya.presentation.TrainingAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.kursovaya.data.model.Training
import com.example.kursovaya.databinding.ItemDayEnabledBinding


class TrainingAdapter : ListAdapter<Int, TrainingViewHolder>(TrainingDiffCallback) {

    var onExerciseItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val binding = ItemDayEnabledBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TrainingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val day = getItem(position)
        holder.binding.tvDay.text = day.toString()

        holder.binding.cardView.setOnClickListener{
            onExerciseItemClickListener?.invoke(day)
        }

    }



}

