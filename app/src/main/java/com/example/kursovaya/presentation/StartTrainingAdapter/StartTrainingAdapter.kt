package com.example.kursovaya.presentation.StartTrainingAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.kursovaya.data.db.ExerciseItemDbModel
import com.example.kursovaya.databinding.ItemExerciseBinding
import com.squareup.picasso.Picasso


class StartTrainingAdapter : ListAdapter<ExerciseItemDbModel, StartTrainingViewHolder>(StartTrainingDiffCallback) {

    var onExerciseItemClickListener: ((ExerciseItemDbModel) -> Unit)? = null

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

                //Picasso.get().load(urlimg).into(ivExercise)
            }
        }

    }






}