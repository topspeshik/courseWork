package com.example.kursovaya.presentation.AddDayAdapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import com.example.kursovaya.data.model.Training
import com.example.kursovaya.databinding.ItemExerciseAddBinding

class AddExerciseAdapter(
    private val context: Context
) : ListAdapter<Training, AddExerciseViewHolder>(AddExerciseDiffCallback) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddExerciseViewHolder {
        val binding = ItemExerciseAddBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AddExerciseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddExerciseViewHolder, position: Int) {
        val exercise = getItem(position)
        with(holder.binding){
            with(exercise){
                tvName.text = name
            }
        }

    }


}