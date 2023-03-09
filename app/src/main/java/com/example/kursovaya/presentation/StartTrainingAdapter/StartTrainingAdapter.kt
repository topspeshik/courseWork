package com.example.kursovaya.presentation.StartTrainingAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.kursovaya.data.db.ExerciseItemDbModel
import com.example.kursovaya.databinding.ItemExerciseBinding


class StartTrainingAdapter : ListAdapter<ExerciseItemDbModel, StartTrainingViewHolder>(StartTrainingDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartTrainingViewHolder {
        val binding = ItemExerciseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StartTrainingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StartTrainingViewHolder, position: Int) {
        val exercise = getItem(position)

        with(holder.binding){
            with(exercise){
                tvName.text = exercise_name
                tvDescription.text = "$sets x $reps x $kg kg".filter{ !it.isWhitespace() }
                Glide
                    .with(root.context)
                    .load(urlimg)
                    .into(ivExercise)
            }
        }

    }






}