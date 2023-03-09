package com.example.kursovaya.presentation.AddDayAdapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.kursovaya.data.model.Training
import com.example.kursovaya.databinding.ItemExerciseAddBinding
import com.squareup.picasso.Picasso

class AddExerciseAdapter : ListAdapter<Training, AddExerciseViewHolder>(AddExerciseDiffCallback) {

    var onExerciseItemClickListener: ((Training) -> Unit)? = null

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
                Glide
                    .with(root.context)
                    .load(urlimg)
                    .into(ivExercise)

                ivExerciseAdd.setOnClickListener{
                    onExerciseItemClickListener?.invoke(this)
                }

            }
        }



    }


}